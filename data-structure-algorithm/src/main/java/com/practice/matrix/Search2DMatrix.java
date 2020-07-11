package com.practice.matrix;
/*
Leetcode#74. Search a 2D Matrix
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

-Integers in each row are sorted from left to right.
-The first integer of each row is greater than the last integer of the previous row.
*/
public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length != 0) {
			int lower = 0;
			int upper = (matrix.length * matrix[0].length) - 1;

			int col = matrix[0].length;
			while (lower <= upper) {
				int mid = (lower + upper) / 2;
				if (matrix[mid / col][mid % col] == target) {
					return true;
				} else if (matrix[mid / col][mid % col] > target) {
					upper = mid - 1;
				} else {
					lower = mid + 1;
				}
			}
		}
        
        return false;
    }
    
    public static void main(String[] s) {
    	int[][] input = {{1,3,5,7},
    					{10,11,16,20},
    					{23,30,34,50}};
    			
    	System.out.println(searchMatrix(input, 16));
    }
}
