package com.learning.java8.optional;

import java.util.Optional;
/*
This class is used to deal with NullPointerException in Java application
*/
public class OptionalExercise {

	public static void main(String[] args) {
		String s = "Hi";
		String x = null;
		Optional<String> value = Optional.ofNullable(s);
		
		if(value.isPresent()) {
			System.out.println("The value is: " + value.get());
		}
		
		System.out.println(value.orElse("null value"));

		value.ifPresent(System.out::println);


	}

}
