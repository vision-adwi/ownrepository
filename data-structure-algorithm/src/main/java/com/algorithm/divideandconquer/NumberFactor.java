package com.algorithm.divideandconquer;

import com.algorithm.INumberFactor;

/*
Problem Statement

*/
public class NumberFactor implements INumberFactor{
	
	public long waysToGet(int n) {
		if((n == 0) || (n == 1) || (n == 2)) { //{}, {1}, {1,1}
			return 1L;
		}
		if(n == 3) { //{1, 1, 1}, {3}
			return 2L;
		}
		long subtract1 = waysToGet(n - 4);
		long subtract2 = waysToGet(n - 3);
		long subtract3 = waysToGet(n - 1);
		
		long sum = subtract1+ subtract2 + subtract3;
		return sum;
	}

	@Override
	public long solve(int n) {
		return waysToGet(n);
	}
}
