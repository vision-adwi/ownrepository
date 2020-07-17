package com.practice.backtracking;
/*
Leetcode#1219. Path with Maximum Gold
In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position you can walk one step to the left, right, up or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.
*/
public class MaximumGold {
	public int getMaximumGold(int[][] grid) {
		int maxGoldCollect = 0;
		for(int row = 0; row < grid.length; row++) {
			for(int column = 0; column < grid[0].length; column++) {
				if(grid[row][column] != 0) {
					int goldCollect = maxGold(cloneArray(grid), row, column, 0);
					System.out.println(goldCollect);
					maxGoldCollect = Math.max(maxGoldCollect, goldCollect);	
				}
			}
		}
        
		return maxGoldCollect;
    }
	
	private int maxGold(int[][] grid, int row, int column, int sum) {
		if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] <= 0) {
			return sum;
		}
		
		int newSum = sum + grid[row][column];
		grid[row][column] = -grid[row][column];
		
		int left = maxGold(grid, row, column - 1, newSum);
		int right = maxGold(grid, row, column + 1, newSum);
		int top = maxGold(grid, row - 1, column, newSum);
		int bottom = maxGold(grid, row + 1, column, newSum);
		
		return Math.max(left, Math.max(right, Math.max(top, bottom)));
	}
	
	private int[][] cloneArray(int[][] source) {
		int[][] destination = source.clone();
		for(int row = 0; row < source.length; row++) {
			destination[row] = source[row].clone();
		}

		return destination;
	}
	
	public static void main(String[] s) {
		//int[][] input = {{0,6,0},{5,8,7},{0,9,0}};
		int[][] input = {
			{0,0,0,0,0,0,32,0,0,20},
			{0,0,2,0,0,0,0,40,0,32},
			{13,20,36,0,0,0,20,0,0,0},
			{0,31,27,0,19,0,0,25,18,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,18,0,6},
			{0,0,0,25,0,0,0,0,0,0},
			{0,0,0,21,0,30,0,0,0,0},
			{19,10,0,0,34,0,2,0,0,27},
			{0,0,0,0,0,34,0,0,0,0}
		};
		
		
		MaximumGold maxGold = new MaximumGold();
		System.out.println(maxGold.getMaximumGold(input));
	}
}
