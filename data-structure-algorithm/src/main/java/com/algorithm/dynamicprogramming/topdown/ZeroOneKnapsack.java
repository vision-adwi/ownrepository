package com.algorithm.dynamicprogramming.topdown;

import com.algorithm.IZeroOneKnapsack;

public class ZeroOneKnapsack implements IZeroOneKnapsack{
	@Override
	public int maximize(int[] weights, int[] profits, int limit) {
		int[][] mem = new int[weights.length + 1][limit + 1];
		return maximizeProfit(weights, profits, 0, limit, mem);
	}
	
	private int maximizeProfit(int[] weights, int[] profits, int index, int limit, int[][] mem) {
		if ((index >= profits.length) || (limit <= 0))
			return 0;

		if (mem[index][limit] == 0) {
			int t1 = 0;
			if (limit >= weights[index]) {
				t1 = profits[index] + maximizeProfit(weights, profits, index + 1, limit - weights[index], mem);
			}
			int t2 = maximizeProfit(weights, profits, index + 1, limit, mem);
			mem[index][limit] = Math.max(t1, t2);
		}

		return mem[index][limit];
	}
}
