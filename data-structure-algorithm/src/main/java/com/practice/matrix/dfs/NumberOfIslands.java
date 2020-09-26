package com.practice.matrix.dfs;

/* Leetcode #200 Number of islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
	public static int countIslands(char[][] input) {
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				if (input[i][j] == '1') {
					countIslandsUtil(input, i, j);
					count++;
				}
			}
		}
		
		return count;
	}

	private static void countIslandsUtil(char[][] copy, int i, int j) {
		if (i < 0 || j < 0 || i >= copy.length || j >= copy[0].length || copy[i][j] != '1') {
			return;
		}

		copy[i][j] = '2'; 

		countIslandsUtil(copy, i - 1, j);
		countIslandsUtil(copy, i + 1, j);
		countIslandsUtil(copy, i, j - 1);
		countIslandsUtil(copy, i, j + 1);
	}

	public static void main(String[] args) {
		char[][] input = {
				  {'1','1','1','1','0'},
				  {'1','1','0','1','0'},
				  {'1','1','0','0','0'},
				  {'0','0','0','0','0'}
				};

		int numberOfIslands = countIslands(input);
		System.out.println("Total number of Islands = " + numberOfIslands);
	}
}
