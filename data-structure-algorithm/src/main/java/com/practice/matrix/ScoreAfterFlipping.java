package com.practice.matrix;
/*
Leetcode#861. Score After Flipping Matrix
We have a two dimensional matrix A where each value is 0 or 1.
A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.
After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.
Return the highest possible score.
*/
public class ScoreAfterFlipping {
	public int matrixScore(int[][] A) {
		for(int row = 0; row < A.length; row++) {
			if(A[row][0] == 0) {
				flipRow(A, row);
			}
		}
		
		for(int column = 1; column < A[0].length; column++) {
			int zeros = 0;
			for(int row = 0; row < A.length; row++) {
				if(A[row][column] == 0)
					++zeros;
			}
			if(zeros > (A.length / 2))
				flipColumn(A, column);
		}
        
		int score = 0;
		for(int row = 0; row < A.length; row++)
			score = score + binToInt(A[row]);
			
		return score;
    }
	
	private void flipRow(int[][] A, int row) {
		for(int column = 0; column < A[0].length; column++) {
			A[row][column] = A[row][column] ^ 1;
		}
	}
	
	private void flipColumn(int[][] A, int column) {
		for(int row = 0; row < A.length; row++) {
			A[row][column] = A[row][column] ^ 1;
		}
	}
	
	private int binToInt(int[] bin) {
		int val = 0; int radix = 1;
		for(int i = bin.length - 1; i >= 0; i--) {
			val = val + (bin[i] * radix);
			radix = radix << 1;
		}
		return val;
	}
	
	public static void main(String[] s) {
		int[][] input = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
		ScoreAfterFlipping flip = new ScoreAfterFlipping();
		System.out.println(flip.matrixScore(input));
		
	}

}
