package com.practice.graph;

/* Leetcode #200 Number of islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
	public static void main(String[] args) {
		int[][] input = { 	{ 1, 1, 0, 1, 0 }, 
							{ 1, 1, 0, 1, 0 }, 
							{ 1, 1, 0, 0, 0 }, 
							{ 0, 0, 0, 0, 0 }, 
							{ 0, 0, 1, 0, 1 },
							{ 1, 1, 1, 0, 0 } };

		// Apply modified DFS
		int numberOfIslands = countIslands(input);
		System.out.println("Total number of Islands = " + numberOfIslands);
	}

	private static int countIslands(int[][] input) {
		int row = input.length;
		int column = input[0].length;
		int[][] copy = input.clone();
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (copy[i][j] == 1) {
					countIslandsUtil(copy, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private static void countIslandsUtil(int[][] copy, int i, int j) {
		if (i < 0 || j < 0 || i >= copy.length || j >= copy[0].length || copy[i][j] != 1) {
			return;
		}

		copy[i][j] = -1; //Processed

		countIslandsUtil(copy, i - 1, j);
		countIslandsUtil(copy, i + 1, j);
		countIslandsUtil(copy, i, j - 1);
		countIslandsUtil(copy, i, j + 1);

	}

}
