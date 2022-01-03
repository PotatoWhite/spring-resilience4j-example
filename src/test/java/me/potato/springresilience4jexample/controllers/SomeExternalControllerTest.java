package me.potato.springresilience4jexample.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import me.potato.springresilience4jexample.dto.Some;

/**
 * @author dongju.paek
 */
@ExtendWith(MockitoExtension.class)
class SomeExternalControllerTest {

	@Test
	public void callExternalSome(){
		var response = WebClient.builder().baseUrl("http://localhost:8080").build().post().uri("external/some")
			.retrieve()
			.bodyToMono(Some.class)
			.block();

		Assertions.assertTrue(response.getName().equals("당근"));
	}

}