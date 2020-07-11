package com.practice.matrix;
/*
Leetcode#240. Search a 2D Matrix II
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

-Integers in each row are sorted in ascending from left to right.
-Integers in each column are sorted in ascending from top to bottom.
*/
public class Search2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int row = 0;
        int column = matrix[0].length - 1;
        while(row < matrix.length && column >= 0) {
            if(matrix[row][column] == target) {
                return true;
            }
            else if(matrix[row][column] > target) {
                --column;
            }
            else {
                ++row;
            }
        }
        return false;
    }
}
