package com.algorithm.dynamicprogramming.topdown;

import java.util.Arrays;

import com.algorithm.INumberOfPaths;

public class NumberOfPaths implements INumberOfPaths{
	@Override
	public int pathFinder(int[][] matrix, int cost) {
		int[][] mem = new int[matrix.length][matrix[0].length];
		/*for(int row = 0; row < matrix.length; row++)
			Arrays.fill(mem[row], -1);*/
		return exploerPaths(matrix, cost, matrix.length - 1, matrix[0].length - 1, mem);
	}
	
	private int exploerPaths(int[][] matrix, int costRemaining, int row, int column, int[][] mem) {
		if (costRemaining < 0) {
			return 0;
		}
		
		if (row == 0 && column == 0) {
			return ((costRemaining - matrix[0][0]) == 0) ? 1 : 0;
		}

		if (mem[row][column] == 0) {
			if(row == 0) {
				mem[row][column] = exploerPaths(matrix, costRemaining - matrix[row][column], row, column - 1, mem);
			}
			else if(column == 0) {
				mem[row][column] = exploerPaths(matrix, costRemaining - matrix[row][column], row - 1, column, mem);
			}
			else {
				int leftPath = exploerPaths(matrix, costRemaining - matrix[row][column], row - 1, column, mem);
				int upPath = exploerPaths(matrix, costRemaining - matrix[row][column], row, column - 1, mem);
				mem[row][column] = leftPath + upPath;
			}
		}

		return mem[row][column];
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
