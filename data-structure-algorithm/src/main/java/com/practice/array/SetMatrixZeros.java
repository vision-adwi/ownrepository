package com.practice.array;

import java.util.HashSet;
import java.util.Set;
/*
Leetcode#73. Set Matrix Zeroes
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
*/
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
    	int rows = matrix.length;
    	int columns = matrix[0].length;
    	
    	Set<Integer> rowSet = new HashSet<>();
    	Set<Integer> columnSet = new HashSet<>();
    	for(int i = 0; i < rows; i++) {
    		for(int j = 0; j < columns; j++) {
    			if(matrix[i][j] == 0) {
    				rowSet.add(i);
    				columnSet.add(j);
    			}
    		}
    	}
    	
    	for(Integer row : rowSet) {
    		for(int j = 0; j < columns; j++)
    			matrix[row][j] = 0;
    	}
    	
    	for(Integer column : columnSet) {
    		for(int i = 0; i < rows; i++)
    			matrix[i][column] = 0;
    	}
        
    }
}
