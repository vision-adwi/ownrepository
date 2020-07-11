package com.practice.matrix;
/*
Leetcode#59. Spiral Matrix II
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
*/
public class SpiralMatrix2 {
	public int[][] generateMatrix(int n) {	
    	int[][] matrix = new int[n][n];
    	int num = 1;

    	int right = n;
    	int bottom = n;
    	int left = 0;
    	int top = 1;
    	
    	int row = -1, column = -1; 
		while (true) {
			row++; column++;
			while (column < right) 
				matrix[row][column++] = num++;

			if(num > (n*n)) break;
			
			column--; row++;
			while (row < bottom) 
				matrix[row++][column] = num++;
			
			if(num > (n*n)) break;
			
			row--; column--;
			while (column >= left) 
				matrix[row][column--] = num++;

			if(num > (n*n)) break;
			
			column++; row--;
			while (row >= top) 
				matrix[row--][column] = num++;
			
			if(num > (n*n)) break;

			right--; bottom--; left++; top++;
		}

    	return matrix;
    }
}
