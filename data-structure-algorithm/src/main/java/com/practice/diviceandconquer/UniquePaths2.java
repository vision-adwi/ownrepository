package com.practice.diviceandconquer;
/*
Leetcode#63. Unique Paths II
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner 
of the grid (marked 'Finish' in the diagram below).
Now consider if some obstacles are added to the grids. How many unique paths would there be?
*/		
public class UniquePaths2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;
		int[][] mem = new int[row][col];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(obstacleGrid[i][j] == 1) {
					mem[i][j] = 0;
				}
				else if(i == 0 && j == 0) {
					mem[i][j] = 1;
				}
				else if(i == 0) {
					mem[i][j] = mem[i][j - 1];
				}
				else if(j == 0) {
					mem[i][j] = mem[i - 1][j];
				}
				else {
					mem[i][j] = mem[i - 1][j] + mem[i][j - 1];
				}
			}
		}
		
		return mem[row - 1][col - 1];
	}
	
    public int uniquePathsWithObstacles_td(int[][] obstacleGrid) {
    	int[][] mem = new int[obstacleGrid.length][obstacleGrid[0].length];
        return findPaths(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1, mem);
    }
    
	private int findPaths(int[][] grid, int row, int col, int[][] mem) {
		if (row == -1 || col == -1 || grid[row][col] == 1)
			return 0;
		
		if (row == 0 && col == 0) {
			return 1;
		}

		if (mem[row][col] == 0) {

			int rightWays = findPaths(grid, row - 1, col, mem);
			int upWays = findPaths(grid, row, col - 1, mem);

			mem[row][col] = rightWays + upWays;
		}

		return mem[row][col];
	}
}
