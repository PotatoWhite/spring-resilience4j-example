
/*
 * ExternalController.java 2022. 01. 03
 *
 * Copyright 2022 Naver Cloud Corp. All rights Reserved.
 * Naver Cloud Corp. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.springresilience4jexample.controllers;

import java.time.Duration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import me.potato.springresilience4jexample.dto.Some;
import reactor.core.publisher.Mono;

/**
 * @author dongju.paek
 */
@Slf4j
@RequestMapping("external")
@RestController
public class SomeExternalController {
	private final String BASEURL = "http://localhost:8080";

	@CircuitBreaker(name="someFallBackService", fallbackMethod = "createSomeFallback")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("some")
	public Mono<Some> createSome() {
		var some = new Some("감자", "고구마");
		return WebClient.builder().baseUrl(BASEURL).build()
			.post().uri("/internal/some")
			.bodyValue(some)
			.retrieve()
			.bodyToMono(Some.class)
			.timeout(Duration.ofMillis(200))
			.retry(5);
	}

	public Mono<Some> createSomeFallback(Exception e){
		var some = new Some("Error 감자", "Error 고구마");
		return Mono.just(some);
	}

}