 package com.algorithm.dynamicprogramming.bottomup;

import com.algorithm.INumberFactor;

public class NumberFactor implements INumberFactor{
	@Override
	public long solve(int n) {
		if(n == 0 || n == 1 || n == 2)
			return 1;
		
		if(n == 3)
			return 2;
		
		long[] memory = new long[n + 1];

		memory[0] = memory[1] = memory[2] = 1L;
		memory[3] = 2L;
		
		for(int i = 4; i <= n; i++) {
			memory[i] = memory[i-4] + memory[i-3] + memory[i-1];
		}
		
		return memory[n];
	}
}
