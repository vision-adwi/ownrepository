package com.practice.matrix;
/*
LendingKart interview questions. 
*/

public class IslandsWithHanger {
	public static void main(String[] args) {
		int[][] input = { 	{ 1, 1, 0, 1, 0 }, 
							{ 1, 1, 0, 1, 0 }, 
							{ 1, 1, 0, 0, 0 }, 
							{ 0, 0, 0, 0, 0 }, 
							{ 0, 0, 1, 0, 1 },
							{ 1, 1, 1, 0, 0 } };

		int isLandsWithHangerFacility = isLandWithHanger(input);
		System.out.println("No. of islands with hanger facility = " + isLandsWithHangerFacility);
	}

	private static int isLandWithHanger(int[][] input) {
		int hangers = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				if (input[i][j] == 1) {
					if((islandAreaCalculation(input, i, j, 0) % 2) == 0 )
						hangers++;
				}
			}
		}
		return hangers;
	}

	private static int islandAreaCalculation(int[][] copy, int i, int j, int count) {
		if (i < 0 || j < 0 || i >= copy.length || j >= copy[0].length || copy[i][j] != 1) {
			return count;
		}

		copy[i][j] = -1; //Processed
		count++;

		count = islandAreaCalculation(copy, i - 1, j, count);
		count = islandAreaCalculation(copy, i + 1, j, count);
		count = islandAreaCalculation(copy, i, j - 1, count);
		count = islandAreaCalculation(copy, i, j + 1, count);

		return count;
	}

}
