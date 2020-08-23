package com.algorithm.divideandconquer;

import com.algorithm.IZeroOneKnapsack;

public class ZeroOneKnapsack implements IZeroOneKnapsack{
	@Override
	public int maximize(int[] weights, int[] profits, int limit) {
		return maximizeProfit(weights, profits, 0, limit);
	}
	
	private int maximizeProfit(int[] weights, int[] profits, int index, int limit) {
		if((index >= profits.length) || (limit <= 0))
			return 0;

		int t1 = 0;
		if (limit >= weights[index]) {
			t1 = profits[index] + maximizeProfit(weights, profits, index + 1, limit - weights[index]);
		}
		int t2 = maximizeProfit(weights, profits, index + 1, limit);
		
		return Math.max(t1, t2);
	}
}
