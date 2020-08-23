package com.practice.dynamicprogramming;

public class Easy {
	/*
	Leetcode#509. Fibonacci Number
	The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, 
	such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

	F(0) = 0,   F(1) = 1
	F(N) = F(N - 1) + F(N - 2), for N > 1.
	Given N, calculate F(N).
    */
	public int fib(int N) {
        if(N == 0)
            return 0;
        
        int[] memory = new int[N + 1];
        memory[0] = 0;
        memory[1] = 1;
        for(int i = 2; i <= N; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }

        return memory[N];
    }
	
	/*
	Leetcode#70. Climbing Stairs
	You are climbing a stair case. It takes n steps to reach to the top.
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	*/
	public int climbStairs(int n) {
		if(n == 0)
			return 1;
		
		int[] memory = new int[n + 1];
		memory[0] = 1;
		memory[1] = 1;
		for(int i = 2; i <= n; i++) {
			memory[i] = memory[i -1] + memory[i - 2];
		}
		
		return memory[n];
	}
	
	/*
	Leetcode#62. Unique Paths
	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	How many possible unique paths are there?
	*/
    public int uniquePaths(int m, int n) {
    	int[][] mem = new int[m + 1][n + 1];    	
    	for(int i = m - 1; i >= 0; i--) {
    		for(int j = n - 1; j >= 0; j--) {
    			if(i == (m - 1) && j == (n - 1)) {
    				mem[i][j] = 1;
    			}
    			else {
    				mem[i][j] = mem[i + 1][j] + mem[i][j + 1];
    			}
    		}
    	}
    	    	
		return mem[0][0];
    }
    
    /*
    Leetcode#122. Best Time to Buy and Sell Stock II
    Say you have an array prices for which the ith element is the price of a given stock on day i.
    Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
    (i.e., buy one and sell one share of the stock multiple times).
    */
	//Valley-peak appraoch
	public int maxProfit(int[] prices) {
		int profit = 0;
		for(int i = 0; i < prices.length - 1; i++) {
			if(prices[i] < prices[i + 1]) {
				profit = profit + (prices[i + 1] - prices[i]);
			}
		}
		return profit;
    }
}
