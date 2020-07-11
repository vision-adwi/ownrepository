package com.algorithm.dynamicprogramming.topdown;

import com.algorithm.IFibonacciNumber;

public class FibonacciNumber implements IFibonacciNumber{
	@Override
	public int calculate(int n) {
		int[] mem = new int[n+1];
		return calculateFib(n, mem);
		
	}
	
	private int calculateFib(int n, int[] mem) {
		if (n <= 2)
			return n - 1;

		if (mem[n] == 0) {
			int n1 = calculateFib(n - 1, mem);
			int n2 = calculateFib(n - 2, mem);
			mem[n] = n1 + n2;
		}

		return mem[n];
	}

}
