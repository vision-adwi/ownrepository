package com.learning.springboot.fluxandmonotests;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxTestCases {	
/*	@Test
	public void fluxTest() {
		Flux<String> stringFlux = Flux.just("First", "Second", "Third")
				//.concatWith(Flux.error(new RuntimeException("This is a test error...")))
				.concatWith(Flux.just("After error"));
				//.log();

		stringFlux.subscribe(System.out::println,
				e -> System.out.println(e),
				() -> System.out.println("All elements received"));		
	}
	
	@Test
	public void fluxTestElements_withoutError() {
		Flux<String> stringFlux = Flux.just("First", "Second", "Third")
				.log();

		StepVerifier.create(stringFlux)
				.expectNext("First")
				.expectNext("Second")
				.expectNext("Third")
				.verifyComplete();		
	}

	@Test
	public void fluxTestElements_withError() {
		Flux<String> stringFlux = Flux.just("First", "Second", "Third")
				.concatWith(Flux.error(new RuntimeException("This is a test error...")))
				.log();

		StepVerifier.create(stringFlux)
				.expectNext("First")
				.expectNext("Second")
				.expectNext("Third")
				//.expectError(RuntimeException.class)
				.expectErrorMessage("This is a test error...")
				.verify();		
	}
*/	
	@Test
	public void fluxTestElementsCount_withError() {
		Flux<String> stringFlux = Flux.just("First", "Second", "Third")
				.concatWith(Flux.error(new RuntimeException("This is a test error...")))
				.log();

		StepVerifier.create(stringFlux)
				.expectNext("First", "Second", "Third")  //choose this
				//.expectNextCount(3)					 //OR this
				//.expectError(RuntimeException.class)				//choose this
				.expectErrorMessage("This is a test error...")		//OR this
				.verify();		
	}
}
