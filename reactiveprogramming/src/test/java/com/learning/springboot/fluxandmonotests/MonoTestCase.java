package com.learning.springboot.fluxandmonotests;

import org.junit.Test;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class MonoTestCase {
	
	@Test
	public void monoTest() {
		Mono<String> stringMono = Mono.just("Once").log();
		
		stringMono.subscribe(System.out::println);
		
	}
	
	@Test
	public void monoTest_withoutError() {
		Mono<String> stringMono = Mono.just("Once");
		
		StepVerifier.create(stringMono)
				.expectNext("Once")
				.verifyComplete();
	}
	
	@Test
	public void monoTest_withError() {
		Mono<String> stringMono = Mono.error(new RuntimeException("Exception from mono"));
		
		StepVerifier.create(stringMono)
				.expectError(RuntimeException.class)
				.verify();
	}
}
