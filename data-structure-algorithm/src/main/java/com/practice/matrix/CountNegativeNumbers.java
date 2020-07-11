package com.practice.matrix;
/*
Leetcode#1351. Count Negative Numbers in a Sorted Matrix
Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise. 
Return the number of negative numbers in grid.
*/
public class CountNegativeNumbers {
	public int countNegatives(int[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;
		
		int count = 0;
		for(int i = 0; i < rows; i++) {
			if(grid[i][0] < 0) {
				count = count + ((rows - i) * columns);
				break;
			}
			for(int j = columns - 1; j >= 0; j--) {
				if(grid[i][j] < 0) {
					count++;
				}
				else {
					break;
				}
			}
		}
        
		return count;
    }
}
