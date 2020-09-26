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
				for(int column = 0; column < A[0].length; column++) {
					A[row][column] = A[row][column] ^ 1;
				}
			}
		}
		
		for(int column = 1; column < A[0].length; column++) {
			int zeros = 0;
			for(int row = 0; row < A.length; row++) {
				if(A[row][column] == 0)	
					zeros++;
			}
			if(zeros > (A.length / 2)) {
				for(int row = 0; row < A.length; row++) {
					A[row][column] = A[row][column] ^ 1;
				}
			}
		}
        
		int score = 0;
		for(int row = 0; row < A.length; row++) {
			int val = 0; int radix = 0;
			for(int column = A[0].length - 1; column >= 0; column--) {
				val += A[row][column] << radix++;
			}
			score = score + val;
		}
			
		return score;
    }

	public static void main(String[] s) {
		int[][] input = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
		ScoreAfterFlipping flip = new ScoreAfterFlipping();
		System.out.println(flip.matrixScore(input));
		
	}

}
