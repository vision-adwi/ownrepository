package com.practice.dynamicprogramming;

import java.util.Arrays;

public class EasyTricky {
	/*
	Leetcode#121. Best Time to Buy and Sell Stock
	Say you have an array for which the ith element is the price of a given stock on day i.
	If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
	design an algorithm to find the maximum profit.
	Note that you cannot sell a stock before you buy one.
	*/
	public int maxProfit(int[] prices) {
		if(prices.length == 0)
			return 0;
		
		int[] mem = new int[prices.length];
		mem[prices.length - 1] = 0;
		
		int max = 0;
		for(int i = mem.length - 2; i >= 0; i--) {
			int diff = prices[i + 1] - prices[i];
			mem[i] = Math.max(diff, diff + mem[i + 1]);
			max = Math.max(max, mem[i]);
		}
		
		return max;
	}
	
	/*
	Leetcode#53. Maximum Subarray
	Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
	*/
	public int maxSubArray(int[] nums) {
		if(nums.length == 0)
			return 0;
		
		int[] mem = new int[nums.length];
		mem[0] = nums[0];
		
		int max = nums[0];
		for(int i = 1; i < nums.length; i++) {
			mem[i] = Math.max(mem[i - 1] + nums[i], nums[i]);
			max = Math.max(max, mem[i]);
		}
		
		return max;
	}
	
	/*
	Leetcode#1423. Maximum Points You Can Obtain from Cards

	There are several cards arranged in a row, and each card has an associated number of points The points are given in the integer array cardPoints.
	In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
	Your score is the sum of the points of the cards you have taken.
	Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
	*/
	public int maxScore(int[] cardPoints, int k) {
		int[] fwd_sum = new int[k + 1];
		int[] bck_sum = new int[k + 1];
		
		for(int i = 1; i <= k; i++) {
			fwd_sum[i] = fwd_sum[i - 1] + cardPoints[i - 1];
		}
		
		int x = cardPoints.length - 1;
		for(int j = k - 1; j >= 0; j--) {
			bck_sum[j] = bck_sum[j + 1] + cardPoints[x--];
		}
		
		int max = 0;
		for(int i = 0; i <= k; i++) {
			max = Math.max(max, (fwd_sum[i] + bck_sum[i]));
		}
		
		return max;
		
	}	
	
	/*
	Leetcode#64. Minimum Path Sum
	Minimum cost to reach last cell in a 2D matrix.
	We are given a 2 D matrix to access each have cost associated to it. Start from top left corner and
	end up at right down corner.
	Challenge is to find out the minimum cost to reach when movements allowed are down and right only.
	*/
	public int minCost(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		
		int[][] mem = new int[row + 1][col + 1];
		Arrays.fill(mem[0], Integer.MAX_VALUE);
		mem[0][1] = 0;
		for(int i = 2; i <= row; i++)
			mem[i][0] = Integer.MAX_VALUE;
		
		
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				mem[i][j] = grid[i - 1][j - 1] + Math.min(mem[i - 1][j], mem[i][j - 1]);
			}
		}
		
		return mem[row][col];
	}
	
	
}
