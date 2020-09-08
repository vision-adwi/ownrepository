package com.practice.matrix;

import java.util.Arrays;
/*
Leetcode#73. Set Matrix Zeroes
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
*/
public class SetMatrixZeros {
	public void setZeroes(int[][] matrix) {
		boolean firstCol = false;
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		for(int i = 0; i < rows; i++) {
			if(matrix[i][0] == 0)
				firstCol = true;
			
			for(int j = 1; j < cols; j++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		
	    // See if the first row needs to be set to zero as well
	    if (matrix[0][0] == 0) {
	      for (int j = 0; j < cols; j++) {
	        matrix[0][j] = 0;
	      }
	    }

	    // See if the first column needs to be set to zero as well
	    if (firstCol) {
	      for (int i = 0; i < rows; i++) {
	        matrix[i][0] = 0;
	      }
	    }
	}
	
    public void setZeroes_(int[][] matrix) {
    	boolean[] col_bits = new boolean[matrix[0].length];
    	for(int row = 0; row < matrix.length; row++) {
    		boolean setBit = false;
    		for(int column = 0; column < matrix[0].length; column++) {
    			if(matrix[row][column] == 0) {
    				col_bits[column] = true;
    				setBit = true;
    			}
    		}
    		if(setBit)
    			Arrays.fill(matrix[row], 0);
    	}

    	for(int j = 0; j < col_bits.length; j++) {
    		if(col_bits[j]) {
    			for(int row = 0; row < matrix.length; row++) {
    				matrix[row][j] = 0;
    			}
    		}
    	}
        
    }
    
    public static void main(String[] s) {
    	SetMatrixZeros zeros = new SetMatrixZeros();
    	zeros.setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }
}
