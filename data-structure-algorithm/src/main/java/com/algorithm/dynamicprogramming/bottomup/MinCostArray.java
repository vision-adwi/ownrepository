package com.algorithm.dynamicprogramming.bottomup;

import com.algorithm.IMinCost2D;

public class MinCostArray implements IMinCost2D{
	
	@Override
	public int minCost(int[][] grid) {
		int[][] mem = new int[grid.length][grid[0].length];

		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				if(row == 0 && col == 0) {
					mem[row][col] = grid[row][col];
				}
				else {
					if(row == 0) {
						mem[row][col] = grid[row][col] + mem[row][col - 1];
					}
					else if(col == 0) {
						mem[row][col] = grid[row][col] + mem[row - 1][col];
					}
					else {
						mem[row][col] = grid[row][col] + Math.min(mem[row][col - 1], mem[row - 1][col]);
					}
				}
			}
		}

		return mem[grid.length - 1][grid[0].length - 1];		
	}
}
