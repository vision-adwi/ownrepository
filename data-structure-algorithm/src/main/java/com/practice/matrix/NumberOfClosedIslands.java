package com.practice.matrix;

/* Leetcode #1254. Number of Closed Islands
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s 
and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.
 */
public class NumberOfClosedIslands {
	public static void main(String[] args) {
		int[][] input = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
		int numberOfIslands = closedIsland(input);
		System.out.println("Total number of Islands = " + numberOfIslands);
	}

	public static int closedIsland(int[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					if(countIslandsUtil(grid, i, j) == 0)
						count++;						
				}
			}
		}
		
		return count;
	}

	private static int countIslandsUtil(int[][] copy, int i, int j) {
		if (i < 0 || j < 0 || i >= copy.length || j >= copy[0].length) {
			return 1;
		}
		
		if (copy[i][j] != 0) {
			return 0;
		}

		copy[i][j] = 2; 

		int up = countIslandsUtil(copy, i - 1, j);
		int down = countIslandsUtil(copy, i + 1, j);
		int left = countIslandsUtil(copy, i, j - 1);
		int right = countIslandsUtil(copy, i, j + 1);
		
		return Math.max(up, Math.max(down, Math.max(left, right)));
	}

}
