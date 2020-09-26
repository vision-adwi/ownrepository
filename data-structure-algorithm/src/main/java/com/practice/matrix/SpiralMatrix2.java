package com.practice.matrix;
/*
Leetcode#59. Spiral Matrix II
Given a positive integer n, generate a square matrix filled with elements from 1 to n*n in spiral order.
*/
public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
    	int num = 1;

    	int right = matrix[0].length;
    	int bottom = matrix.length;
    	int left = -1;
    	int top = 0;
    	
    	while(true) {
    		for(int col = left + 1; col < right; col++) {
    			matrix[top][col] = num++; 
    		}
    		right--;
    		if(left >= right) break;
    		
    		for(int row = top + 1; row < bottom; row++) {
    			matrix[row][right] = num++;
    		}
    		bottom--;
    		if(top >= bottom) break;
    		
    		for(int col = right - 1; col > left; col--) {
    			matrix[bottom][col] = num++;
    		}
    		left++;
    		if(left >= right) break;
    		
    		for(int row = bottom - 1; row > top; row--) {
    			matrix[row][left] = num++;
    		}
    		top++;
    		if(top >= bottom) break;
    	}

    	return matrix;
    }
}
