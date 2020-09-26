package com.practice.dynamicprogramming;

public class MediumSoft {
	/*
	Leetcode#746. Min Cost Climbing Stairs
	On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
	Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, 
	and you can either start from the step with index 0, or the step with index 1.
	*/
	public int minCostClimbingStairs(int[] cost) {
        int[] memory = new int[cost.length + 1];
		
		for(int i = cost.length - 2; i >= 0; i--) {
			memory[i] = Math.min((cost[i] + memory[i + 1]), (cost[i + 1] + memory[i + 2]));
		}

		return memory[0];
    }
	
	/*
	Leetcode#198. House Robber
	Problem Statement
	- There are n houses built in a line, each of one contain some value in it. 
	- A thief is going to steal a maximum value of these houses.
	- But thief can't steal from two adjacent houses. 
	{6, 7, 1, 30, 8, 2, 4}
	*/
	public long maxStealth(int[] wealth) {
		int[] memory = new int[wealth.length + 2];

		for(int i = wealth.length - 1; i >= 0; i--) {
			memory[i] = Math.max(wealth[i] + memory[i + 2], memory[i + 1]);
		}
		
		return memory[0];
	}
	
	/*
	Leetcode#63. Unique Paths II
	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner 
	of the grid (marked 'Finish' in the diagram below).
	Now consider if some obstacles are added to the grids. How many unique paths would there be?
	*/
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
    	int[][] mem = new int[m + 1][n + 1];    	
    	for(int i = m - 1; i >= 0; i--) {
    		for(int j = n - 1; j >= 0; j--) {
    			if(i == (m - 1) && j == (n - 1)) {
    				mem[i][j] = 1;
    			}
    			else if(obstacleGrid[i][j] == 1) {
    				mem[i][j] = 0;
    			}
    			else {
    				mem[i][j] = mem[i + 1][j] + mem[i][j + 1];
    			}
    		}
    	}
    	    	
		return mem[0][0];
    }

	/*
	Leetcode#714. Best Time to Buy and Sell Stock with Transaction Fee
	Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; 
	and a non-negative integer fee representing a transaction fee.
	You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. 
	You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
	Return the maximum profit you can make.
	*/
	public int maxProfit(int[] prices, int fee) {
		int[][] mem = new int[2][prices.length];
		
		mem[0][0] = 0;
		mem[1][0] = -(prices[0] + fee);
		
		for(int i = 1; i < prices.length; i++) {
			mem[0][i] = Math.max(mem[0][i - 1], (mem[1][i - 1] + prices[i]));
			mem[1][i] = Math.max(mem[1][i - 1], (mem[0][i - 1] - (prices[i] + fee)));
		}
		
		return mem[0][prices.length - 1];
	}
	
	/*
	Leetcode#221. Maximal Square
	Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
	*/ 
	public int maximalSquare(char[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		
		int[][] mem = new int[row][col];
		
		int max = 0;
		for(int i = 0; i < row; i++) {
			if(matrix[i][0] == '1') {
				mem[i][0] = 1;
				max = Math.max(max, 1);
			}
		}
		
		for(int j = 0; j < col; j++) {
			if(matrix[0][j] == '1') {
				mem[0][j] = 1;
				max = Math.max(max, 1);
			}
		}
		
		for(int i = 1; i < row; i++) {
			for(int j = 1; j < col; j++) {
				if(matrix[i][j] == '1') {
					mem[i][j] = Math.min(Math.min(mem[i - 1][j - 1], mem[i - 1][j]), mem[i][j - 1]) + 1;
				}
				max = Math.max(max, mem[i][j]);
			}
		}
		
		return max*max;
	}
	
	public int combinations(int n) {
		if(n < 3)
			return 1;

		int[] memory = new int[n + 1];

		memory[0] = memory[1] = memory[2] = 1;
		memory[3] = 2;
		
		for(int i = 4; i <= n; i++) {
			memory[i] = memory[i-4] + memory[i-3] + memory[i-1];
		}
		
		return memory[n];
	}
}
