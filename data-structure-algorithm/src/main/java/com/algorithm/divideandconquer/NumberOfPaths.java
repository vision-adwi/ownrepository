package com.algorithm.divideandconquer;

public class NumberOfPaths {
	public int pathFinder(int[][] matrix, int cost) {
		return exploerPaths(matrix, cost, 0, 0, 0);
	}
	
	private int exploerPaths(int[][] matrix, int costRemaining, int pathsFound, int row, int column) {
		if(row == (matrix.length - 1) && column == (matrix[0].length - 1)) { //reached last cell
			if((costRemaining - matrix[row][column]) == 0)
				return ++pathsFound;
			else
				return pathsFound;
		}
		
		if(row == matrix.length || column == matrix[0].length) { //reached last column or row
			return pathsFound;
		}
		
		if(costRemaining <= 0)
			return pathsFound;
		
		int cellCost = matrix[row][column];
		pathsFound = exploerPaths(matrix, costRemaining - cellCost, pathsFound, row + 1, column);
		pathsFound = exploerPaths(matrix, costRemaining - cellCost, pathsFound, row, column + 1);
		
		return pathsFound;
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
