package com.practice.matrix;
import java.util.Arrays;
/*
Leetcode#1337. The K Weakest Rows in a Matrix
Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of the k weakest rows in the 
matrix ordered from the weakest to the strongest.
A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, 
or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row, that is, always ones may appear first and then zeros.
*/
import java.util.stream.IntStream;

public class WeakestRows {
	public int[] kWeakestRows(int[][] mat, int k) {
		int[] result = new int[k];
		int i = 0;
		for (int column = 0; column < mat[0].length && i < k ; column++) {
			for (int row = 0; row < mat.length  && i < k; row++) {
				if (mat[row][column] == 0) {
					result[i++] = row;
					Arrays.fill(mat[row], -1);
				}
			}
		}

		for (int row = 0; row < mat.length && i < k; row++) {
			if (mat[row][mat[0].length-1] == 1)
				result[i++] = row;
		}

		return result;
	}

	public static void main(String[] s) {
		WeakestRows weakest = new WeakestRows();
/*		int[][] mat = 
				{{1,1,0,0,0},
				 {1,1,1,1,0},
				 {1,0,0,0,0},
				 {1,1,0,0,0},
				 {1,1,1,1,1}};*/
		
		int[][] mat = {{1,0},{1,0},{1,0},{1,1}};
		
		IntStream.of(weakest.kWeakestRows(mat, 4))
				.forEach(System.out::println);
	}

}
