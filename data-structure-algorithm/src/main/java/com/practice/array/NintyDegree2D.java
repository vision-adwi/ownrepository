package com.practice.array;
/*
Leetcode#48. Rotate Image
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
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
        
        for(int i = 0, j = dimension - 1; i < j; i++, j--) {
        	for(int k = 0; k < dimension; k++) {
        		int tmp = matrix[k][i];
        		matrix[k][i] = matrix[k][j];
        		matrix[k][j] = tmp;
        	}
        }
    }
}
