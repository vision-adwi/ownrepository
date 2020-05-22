package com.practice.numbers;

public class Fibonacci {
	
	private static void generateSeries(int n) {
		for(long i = 1; i <=n; i++) {
			System.out.print(calculate(i) + " ");
		}
	}
	
	private static long calculate(long n) {
		if(n == 1 || n == 2)
			return n - 1;

		return calculate(n-1) + calculate(n-2);
	}
	
	private static long calculateDP(int n, long[] mem) {
		if(n == 1 || n == 2)
			return n - 1;

		if(mem[n] == 0)
			mem[n] = calculateDP((n-1), mem) + calculateDP((n-2), mem);
		return mem[n];
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		long[] mem = new long[51];
		System.out.println(calculateDP(50, mem));
		long end = System.nanoTime();
		System.out.println("Time taken to create fibonacci(with dynamic programming) - " + (end - start) / 1000000 + " milliseconds.");
		
		start = System.nanoTime();
		System.out.println(calculate(50L));
		end = System.nanoTime();
		System.out.println("Time taken to create fibonacci(with divide and conquer) - " + (end - start) / 1000000 + " milliseconds.");

	}
	
	private static void generate(int n) {
		int first = 0;
		int second = 1;
		int tmp;
		int i = 0;
		if(n >= 1) {
			System.out.print(first + " ");
			i++;
		}
		if(n >= 2) {
			System.out.print(second + " ");
			i++;
		}
		while(i++ < n) {
			tmp = first + second;
			first = second;
			second = tmp;
			System.out.print(second + " ");
		}
		
		
	}

}
