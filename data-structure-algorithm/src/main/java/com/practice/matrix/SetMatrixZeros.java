package com.practice.matrix;

import java.util.Arrays;
/*
Leetcode#73. Set Matrix Zeroes
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
*/
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
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
}
