package com.practice.matrix;

public class ZeroOneMatrix {
	public int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for(int row = 0; row < matrix.length; row++) {
        	for(int column = 0; column < matrix[0].length; column++) {
        		result[row][column] = distance(matrix, row, column);
        	}
        }
        
        return result;
    }
	
	private int distance(int[][] mat, int row, int column) {
		if(row < 0 || column < 0 || row >= mat.length || column >= mat[0].length || mat[row][column] < 0) {
			return 20000;
		}
		
		if(mat[row][column] == 0)
			return 0;
		
		mat[row][column] = -1;
		
		int left = distance(mat, row, column - 1);
		int down = distance(mat, row + 1, column);
		int right = distance(mat, row, column + 1);
		int up = distance(mat, row- 1, column);
		
		mat[row][column] = 1;
		
		return 1 + Math.min(left, Math.min(down, Math.min(right, up)));
	}
}
