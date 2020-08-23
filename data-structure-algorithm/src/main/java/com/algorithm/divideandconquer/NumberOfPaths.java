package com.algorithm.divideandconquer;

import com.algorithm.INumberOfPaths;

public class NumberOfPaths implements INumberOfPaths{
	@Override
	public int pathFinder(int[][] matrix, int cost) {
		return exploerPaths(matrix, cost, matrix.length - 1, matrix[0].length - 1);
	}
	
	private int exploerPaths(int[][] matrix, int costRemaining, int row, int column) {
		if(row == -1 || column == -1 || costRemaining < 0 ) { 
			return 0;
		}
		
		if(row == 0 && column == 0) { 
			return ((costRemaining - matrix[0][0]) == 0) ? 1 : 0;
		}
		
		int leftPath = exploerPaths(matrix, costRemaining - matrix[row][column], row - 1, column);
		int upPath = exploerPaths(matrix, costRemaining - matrix[row][column], row, column - 1);
		
		return leftPath + upPath;
	}

	public static void main(String[] s) {
		int[][] input = {
				{4, 7, 1, 6},
				{5, 7, 3, 9},
				{3, 2, 1, 2},
				{7, 1, 6, 3}		
		};
		NumberOfPaths paths = new NumberOfPaths();
		System.out.println(paths.pathFinder(input, 25));
	}

}
