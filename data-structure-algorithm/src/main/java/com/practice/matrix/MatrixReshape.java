package com.practice.matrix;
/*
Leetcode#566. Reshape the Matrix
In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
*/
public class MatrixReshape {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
        if((nums.length * nums[0].length) != (r * c))
            return nums;
        
        int[][] reshaped = new int[r][c];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[0].length; j++) {
                reshaped[count/c][count%c] = nums[i][j];
                count++;
            }
        }
        
        return reshaped;
    }
}
