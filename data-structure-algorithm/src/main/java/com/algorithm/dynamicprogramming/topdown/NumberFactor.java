package com.algorithm.dynamicprogramming.topdown;

import com.algorithm.INumberFactor;

public class NumberFactor implements INumberFactor{
	
	public long waysToGet(int n, long[] memory) {
		if ((n == 0) || (n == 1) || (n == 2)) { // {}, {1}, {1,1}
			return 1L;
		}
		if (n == 3) { // {1, 1, 1}, {3}
			return 2L;
		}
		if (memory[n] == 0) {
			long subtract1 = waysToGet(n - 4, memory);
			long subtract2 = waysToGet(n - 3, memory);
			long subtract3 = waysToGet(n - 1, memory);

			memory[n] = subtract1 + subtract2 + subtract3;
		}
		return memory[n];
	}

	@Override
	public long solve(int n) {
		long[] memory = new long[n + 1];
		return waysToGet(n, memory);
	}
}
