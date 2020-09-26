package com.practice.matrix;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode#54. Spiral Matrix
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
*/
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> result = new ArrayList<>();
    	
    	if(matrix.length == 0)
    		return result;
    	
    	int right = matrix[0].length;
    	int bottom = matrix.length;
    	int left = -1;
    	int top = 0;
    	
    	while(true) {
    		for(int col = left + 1; col < right; col++) {
    			result.add(matrix[top][col]); 
    		}
    		right--;
    		if(left >= right) break;
    		
    		for(int row = top + 1; row < bottom; row++) {
    			result.add(matrix[row][right]);
    		}
    		bottom--;
    		if(top >= bottom) break;
    		
    		for(int col = right - 1; col > left; col--) {
    			result.add(matrix[bottom][col]);
    		}
    		left++;
    		if(left >= right) break;
    		
    		for(int row = bottom - 1; row > top; row--) {
    			result.add(matrix[row][left]);
    		}
    		top++;
    		if(top >= bottom) break;
    	}
    	
    	return result;
    }
}
