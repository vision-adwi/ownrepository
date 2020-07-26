package com.practice.matrix;

/* Leetcode #695 Max Area of Island
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) 
You may assume all four edges of the grid are surrounded by water.
Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 */
public class IslandWithMaxArea {
	public static void main(String[] args) {
		int[][] input = { 	{ 1, 1, 0, 1, 0 }, 
							{ 1, 1, 0, 1, 0 }, 
							{ 1, 1, 0, 0, 0 }, 
							{ 0, 0, 0, 0, 0 }, 
							{ 0, 0, 1, 0, 1 },
							{ 1, 1, 1, 0, 0 } };

		// Apply modified DFS
		int areaOfBiggestIsland = isLandWithMaxArea(input);
		System.out.println("Area of biggest island = " + areaOfBiggestIsland);
	}

	private static int isLandWithMaxArea(int[][] input) {
		int max = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				if (input[i][j] == 1) {
					max = Math.max(max, islandAreaCalculation(input, i, j));
				}
			}
		}

		return max;
	}

	private static int islandAreaCalculation(int[][] copy, int i, int j) {
		if (i < 0 || j < 0 || i >= copy.length || j >= copy[0].length || copy[i][j] != 1) {
			return 0;
		}

		copy[i][j] = -1; //Processed
		
		int count = 0;
		count = count + islandAreaCalculation(copy, i - 1, j);
		count = count + islandAreaCalculation(copy, i + 1, j);
		count = count + islandAreaCalculation(copy, i, j - 1);
		count = count + islandAreaCalculation(copy, i, j + 1);

		return 1 + count;
	}

}
