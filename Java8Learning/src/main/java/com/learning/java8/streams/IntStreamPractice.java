package com.learning.java8.streams;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamPractice {
	static Set<Character> allVowels = new HashSet<>();
	static {
		allVowels.add('a'); allVowels.add('A');
		allVowels.add('e'); allVowels.add('E');
		allVowels.add('i'); allVowels.add('I');
		allVowels.add('o'); allVowels.add('O');
		allVowels.add('u'); allVowels.add('U');
	}
	
	public static void main(String[] args) {
		
	}

	private static void intStream(String[] args) {
		//abc();
		int sum = IntStream.range(0, 100)  
			.filter(x -> (x % 2) == 0) //Process
			.skip(10) //Process
			.limit(20) //Process
			.sum(); //Terminal - count(), min(), max(), average()
		
		System.out.println("Sum: " + sum);
		System.out.println(sumOfDigits(1234));
	}
	
	private static void sort() {
		int num[] = {20, 12, 4, 66, 7, 18, 19, 4, 12, 44, 99, 91, 45, 55, 90};
		IntStream.of(num)  //.generate(Supplier)
			.distinct() //Process
			.map(x -> x * 2) //Process
			.sorted() //Processes
			.forEach(a -> System.out.print(a + " "));  //Terminal
 	}
	
	private static void streamCreator( ) {
		List<Integer> lists = IntStream.rangeClosed(1, 10)
			.boxed() //Process
			.collect(Collectors.toList());
		
		int[] primitives = lists.stream()
				.mapToInt(i -> i)
				.toArray(); //Terminal
		
		boolean greatern = IntStream.of(primitives)
			.limit(3)
			.anyMatch(i -> i > 5); //Terminal
	}
	
	private static long vowelCount(String str) {
		long vowels = str.chars()
				.mapToObj(ch -> (char) ch)
				.filter(ob -> allVowels.contains(ob))
				.count();
		
		return vowels;
	}
	
	private static long sumOfDigits(long num) {
		long sum = String.valueOf(num)
				.chars()
				.map(Character::getNumericValue)
				.sum();
		
		return sum;
	}

}
