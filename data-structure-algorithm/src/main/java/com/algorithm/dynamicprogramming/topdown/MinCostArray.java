package com.algorithm.dynamicprogramming.topdown;

import com.algorithm.IMinCost2D;

public class MinCostArray implements IMinCost2D{
	
	@Override
	public int minCost(int[][] grid) {
		int[][] mem = new int[grid.length][grid[0].length];
		return movement(grid, grid.length - 1, grid[0].length - 1, mem);		
	}
	
	private int movement(int[][] grid, int row, int column, int[][] mem) {
		if ((row == 0) && (column == 0)) {
			return grid[row][column];
		}
		if ((row == -1) || (column == -1)) {
			return Integer.MAX_VALUE;
		}

		if (mem[row][column] == 0) {
			int right = movement(grid, row, column - 1, mem);
			int down = movement(grid, row - 1, column, mem);
			
			mem[row][column] = grid[row][column] + Math.min(right, down);
		}

		return mem[row][column];
	}

}
