package com.practice.matrix;
/*
Leetcode#1329. Sort the Matrix Diagonally
Given a m * n matrix mat of integers, sort it diagonally in ascending order from the top-left to the bottom-right then return the sorted array.
*/	
public class SortDiagonally {
	public int[][] diagonalSort(int[][] mat) {
		int rowThreshold = mat.length - 1;
		int colThreshold = mat[0].length - 1;
		
		while(rowThreshold > 0 && colThreshold > 0) {
			for (int row = 0; row < rowThreshold; row++) {
				for (int column = colThreshold; column > 0; column--) {
					if (mat[row + 1][column] < mat[row][column - 1]) {
						int tmp = mat[row + 1][column];
						mat[row + 1][column] = mat[row][column - 1];
						mat[row][column - 1] = tmp;
					}
				}
			}
			
			rowThreshold--; colThreshold--;
		}

		return mat;
	}
	
	public static void main(String[] s) {
		int[][] input = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
		SortDiagonally sort = new SortDiagonally();
		sort.diagonalSort(input);
	}

}
