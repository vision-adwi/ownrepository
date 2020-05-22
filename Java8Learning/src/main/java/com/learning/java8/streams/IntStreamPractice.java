package com.learning.java8.streams;

import java.util.stream.IntStream;

public class IntStreamPractice {

	public static void main(String[] args) {
		//abc();
		int sum = IntStream.range(0, 100)
			.filter(x -> (x % 2) == 0)
			.skip(10)
			.limit(20)
			.sum();
		
		System.out.println("Sum: " + sum);
	}
	
	private static void sort() {
		int num[] = {20, 12, 4, 66, 7, 18, 19, 4, 12, 44, 99, 91, 45, 55, 90};
		IntStream.of(num)
			.distinct()
			.sorted()
			.forEach(a -> System.out.print(a + " "));
 	}

}
