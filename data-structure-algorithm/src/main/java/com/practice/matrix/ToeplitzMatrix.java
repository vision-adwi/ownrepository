package com.practice.matrix;

public class ToeplitzMatrix {
	public boolean isToeplitzMatrix(int[][] matrix) {
		for(int i = 0; i < matrix[0].length; i++) {
			int row = 0;
			int column = i;
			while(row < (matrix.length - 1) && column < (matrix[0].length - 1)) {
				if(matrix[row][column] != matrix[++row][++column])
					return false; 
			}
		}
		
		for(int j = 1; j < matrix.length; j++) {
			int row = j;
			int column = 0;
			while(row < (matrix.length - 1) && column < (matrix[0].length - 1)) {
				if(matrix[row][column] != matrix[++row][++column])
					return false; 
			}
		}
		
        return true;
    }

}
