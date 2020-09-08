package com.practice.matrix;
/*
Leetcode#766. Toeplitz Matrix
A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
*/		
public class ToeplitzMatrix {
	public boolean isToeplitzMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		for(int i = rows - 1; i > 0; i--) {
			for(int j = cols - 1; j > 0; j--) {
				if(matrix[i][j] != matrix[i - 1][j - 1])
					return false;
			}
		}
		
		return true;
	}

}
