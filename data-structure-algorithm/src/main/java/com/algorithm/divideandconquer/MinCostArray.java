package com.algorithm.divideandconquer;

import com.algorithm.IMinCost2D;

public class MinCostArray implements IMinCost2D{
	
	@Override
	public int minCost(int[][] grid, int row, int column) {
		//terminal condition
		if((row == 0) && (column == 0)){
			return grid[row][column];
		}
		if((row == -1) || (column == -1)) {
			return Integer.MAX_VALUE;
		}

		int right = minCost(grid, row, column - 1);
		int down = minCost(grid, row - 1, column);
		
		return grid[row][column] + Math.min(right, down);
	}

}
