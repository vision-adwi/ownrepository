package com.practice.matrix;
/*
Leetcode#48. Rotate Image
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

90  Degree - Row to col, vertical swap
270 Degree - Row to col, horizontal swap
180 Degree = horizontal swap, vertical swap
*/
public class NintyDegree2D {
    public void rotate(int[][] matrix) {
        int dimension = matrix.length;
        
        for(int i = 0; i < dimension; i++) {
        	for(int j = i + 1; j < dimension; j++) {
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = tmp;
        	}
        }

        int j = 0;
        int k = dimension - 1;
        while(j < k) {
        	for(int i = 0; i < dimension; i++) {
        		int tmp = matrix[i][k];
        		matrix[i][k] = matrix[i][j];
        		matrix[i][j] = tmp;
        	}
        	
        	j++; k--;
        }
    }
}
