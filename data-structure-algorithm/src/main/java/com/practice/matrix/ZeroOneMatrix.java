package com.practice.matrix;
/*
Leetcode#542. 01 Matrix
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
*/
public class ZeroOneMatrix {
	public int[][] updateMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int[][] result = new int[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(matrix[i][j] != 0)
					result[i][j] = Integer.MAX_VALUE - 1;
			}
		}
		
		for(int i = rows - 1; i >= 0; i--) {
			for(int j = cols - 1; j >= 0; j--) {
				optimize(result, i, j);
			}
		}
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				optimize(result, i, j);
			}
		}
		
		return result;
	}
	
	private void optimize(int[][] result, int i, int j) {
		if(result[i][j] != 0) {
			if(i > 0)
				result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
			if(i < result.length - 1)
				result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
			if(j > 0)
				result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
			if(j < result[0].length - 1)
				result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
		}
    }
}
