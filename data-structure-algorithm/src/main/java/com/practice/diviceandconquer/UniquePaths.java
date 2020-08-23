package com.practice.diviceandconquer;
/*
Leetcode#62. Unique Paths
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
*/
public class UniquePaths {
    public int uniquePaths_bu(int m, int n) {
    	int[][] mem = new int[m][n];
    	
    	for(int i = 0; i < m; i++) {
    		for(int j = 0; j < n; j++) {
    			if(i == 0 && j == 0) {
    				mem[i][j] = 1;
    			}
    			else if(i == 0) {
    				mem[i][j] = mem[i][j - 1];
    			}
    			else if(j == 0) {
    				mem[i][j] = mem[i - 1][j];
    			}
    			else {
    				mem[i][j] = mem[i -1][j] + mem[i][j - 1];
    			}
    		}
    	}
    	
    	
		return mem[m - 1][n - 1];
    }
    
    public int uniquePaths_td(int m, int n) {
    	int[][] mem = new int[m][n];
		return findPaths(m - 1, n - 1, mem);
    }
    
	private int findPaths(int row, int col, int[][] mem) {
		if ((row == 0) && (col == 0)) {
			return 1;
		}
		if ((row == -1) || (col == -1)) {
			return 0;
		}

		if (mem[row][col] == 0) {
			int rightCount = findPaths(row, col - 1, mem);
			int upCount = findPaths(row - 1, col, mem);

			mem[row][col] = rightCount + upCount;
		}

		return mem[row][col];
	}
	
	public static void main(String[] s) {
		int row = 4, column = 5;
		UniquePaths maxWays = new UniquePaths();
		
		int ways = maxWays.uniquePaths_td(row - 1, column - 1);
		System.out.println(ways);
	}

}
