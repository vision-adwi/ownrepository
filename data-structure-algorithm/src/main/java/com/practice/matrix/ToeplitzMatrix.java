package com.practice.matrix;
/*
Leetcode#766. Toeplitz Matrix
A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
*/		
public class ToeplitzMatrix {
	public boolean isToeplitzMatrix(int[][] matrix) {	
		for(int row = matrix.length - 2; row >= 0; row--) {
			for(int column = matrix[0].length - 1; column > 0; column--) {
				if(matrix[row+1][column] != matrix[row][column-1])
					return false;
			}
		}
		
        return true;
    }

}
