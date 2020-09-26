package com.practice.matrix.dfs;

/* Leetcode #1254. Number of Closed Islands
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s 
and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.
 */
public class NumberOfClosedIslands {
	public static int closedIsland(int[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					if(countIslandsUtil(grid, i, j))
						count++;						
				}
			}
		}
		
		return count;
	}

	private static boolean countIslandsUtil(int[][] copy, int i, int j) {
		if (i < 0 || j < 0 || i >= copy.length || j >= copy[0].length) {
			return false;
		}
		
		if (copy[i][j] != 0) {
			return true;
		}

		copy[i][j] = 2; 

		boolean upSearch = countIslandsUtil(copy, i - 1, j);
		boolean downSearch = countIslandsUtil(copy, i + 1, j);
		boolean leftSearch = countIslandsUtil(copy, i, j - 1);
		boolean rightSearch = countIslandsUtil(copy, i, j + 1);

		return upSearch && downSearch && leftSearch && rightSearch;
	}
	
	public static void main(String[] args) {
		int[][] input = {
				{1,1,1,1,1,1,1,0},
				{1,0,0,0,0,1,1,0},
				{1,0,1,0,1,1,1,0},
				{1,0,0,0,0,1,0,1},
				{1,1,1,1,1,1,1,0}
				};
		
		int numberOfIslands = closedIsland(input);
		System.out.println("Total number of Islands = " + numberOfIslands);
	}

}
