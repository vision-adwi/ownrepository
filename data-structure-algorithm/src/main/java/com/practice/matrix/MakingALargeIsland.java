package com.practice.matrix;

/* Leetcode #827. Making A Large Island
In a 2D grid of 0s and 1s, we change at most one 0 to a 1.
After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).
 */
public class MakingALargeIsland {
	public static void main(String[] args) {
		/*int[][] input = { 	{ 1, 1, 0, 1, 0 }, 
							{ 1, 1, 0, 1, 0 }, 
							{ 1, 1, 0, 0, 0 }, 
							{ 0, 0, 0, 0, 0 }, 
							{ 0, 0, 1, 0, 1 },
							{ 1, 1, 1, 0, 0 } };*/
		
		int[][] input = { 	{1, 1}, 
				           { 1, 0 } };

		// Apply modified DFS
		int areaOfBiggestIsland = largestIsland(input);
		System.out.println("Area of biggest island = " + areaOfBiggestIsland);
	}

	private static int largestIsland(int[][] grid) {
		int max = 0;
		int marker = 2;
		boolean allOnes = true;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					grid[i][j] = 1;
					max = Math.max(max, islandAreaCalculation(grid, i, j, marker++));
					grid[i][j] = 0;
					allOnes = false;
				}
			}
		}
		
		if(allOnes)
			max = grid.length * grid[0].length;

		return max;
	}

	private static int islandAreaCalculation(int[][] copy, int i, int j, int marker) {
		if (i < 0 || j < 0 || i >= copy.length || j >= copy[0].length || copy[i][j] == marker || copy[i][j] == 0) {
			return 0;
		}

		copy[i][j] = marker; //Processed
		
		int count = 0;
		count = count + islandAreaCalculation(copy, i - 1, j, marker);
		count = count + islandAreaCalculation(copy, i + 1, j, marker);
		count = count + islandAreaCalculation(copy, i, j - 1, marker);
		count = count + islandAreaCalculation(copy, i, j + 1, marker);

		return 1 + count;
	}

}
