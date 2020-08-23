package com.algorithm.dynamicprogramming.bottomup;

import com.algorithm.IFibonacciNumber;

public class FibonacciNumber implements IFibonacciNumber{
	@Override
	public int calculate(int n) {
		if(n == 0)
			return 0;
		
		int[] table = new int[n + 1];
		table[0] = 0;
		table[1] = 1;
		for(int i = 2; i <= n; i++) {
			table[i] = table[i - 1] + table[i - 2];
		}

		return table[n];
	}

}
