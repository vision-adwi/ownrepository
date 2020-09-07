package com.learning.springboot.reactiveprogramming.controller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class MyWebController {
	
	@GetMapping(value = "/flux", produces = MediaType.APPLICATION_STREAM_JSON_VALUE) //"application/stream+json"
	public Flux<String> getFlux() {
		return Flux.just("1", "2", "3", "4")
				.delayElements(Duration.ofSeconds(5)).log();
	}

}
