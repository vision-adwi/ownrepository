package com.practice.numbers;

import java.math.BigInteger;

public class Factorial {

	private static long fact(int n) {
		if (n < 1) {
			return 1L;
		}

		return n * fact(n - 1);
	}

	private static void factorialSeries(int lastRange) {
		long start = System.nanoTime() / 1000;
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i <= lastRange; i++) {
			builder.append(fact(i)).append(" ");
			//System.out.print(fact(i) + " ");
		}
		System.out.println(builder);
		long end = System.nanoTime() / 1000;
		System.out.println("\nTime taken - " + (end - start));
	}

	public static void main(String[] args) {
		// System.out.println("Factorial(1) " + fact(1));
		factorialSeries(20);
		System.out.println();
		factRange(50);

	}

	private static void factRange(int lastRange) {
		long start = System.nanoTime() / 1000;
		BigInteger facto = new BigInteger("1");
		StringBuilder builder = new StringBuilder();
		for (long i = 1; i <= lastRange; i++) {
			facto = facto.multiply(BigInteger.valueOf(i));
			builder.append(facto.longValue()).append(" ");
		}
		System.out.println(builder);
		long end = System.nanoTime() / 1000;
		System.out.println("\nTime taken - " + (end - start));
	}

}
