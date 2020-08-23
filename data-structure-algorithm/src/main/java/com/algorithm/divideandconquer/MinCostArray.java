package com.algorithm.divideandconquer;

import com.algorithm.IMinCost2D;

public class MinCostArray implements IMinCost2D{
	
	@Override
	public int minCost(int[][] grid) {
		return movement(grid, grid.length - 1, grid[0].length - 1);		
	}
	
	private int movement(int[][] grid, int row, int column) {
		if((row == 0) && (column == 0)){
			return grid[row][column];
		}
		if((row == -1) || (column == -1)) {
			return Integer.MAX_VALUE;
		}

		int right = movement(grid, row, column - 1);
		int down = movement(grid, row - 1, column);
		
		return grid[row][column] + Math.min(right, down);
	}

}
