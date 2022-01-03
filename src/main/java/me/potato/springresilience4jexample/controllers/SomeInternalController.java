
/*
 * SomeInternalController.java 2022. 01. 03
 *
 * Copyright 2022 Naver Cloud Corp. All rights Reserved.
 * Naver Cloud Corp. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.springresilience4jexample.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import me.potato.springresilience4jexample.dto.Some;
import reactor.core.publisher.Mono;

/**
 * @author dongju.paek
 */
@Slf4j
@RequestMapping("internal")
@RestController
public class SomeInternalController {

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("some")
	public Mono<Some> createInternalSome(@RequestBody Some body) throws InterruptedException {
		log.info("REQ {}", body);

		body.setName("당근");
		body.setNickname("토마토");

		log.info("RES {}", body);

		Thread.sleep(200L);
		return Mono.just(body);
	}
}