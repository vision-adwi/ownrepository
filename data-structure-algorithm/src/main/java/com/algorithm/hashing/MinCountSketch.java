package com.algorithm.hashing;

public class MinCountSketch {
	private int hashSize = 20;
	private int[][] matrix = new int[4][hashSize];
	
	public void train(byte ch) {
		int h0 = Hashing.h0(ch, hashSize);
		int h1 = Hashing.h1(ch, hashSize);
		int h2 = Hashing.h2(ch, hashSize);
		int h3 = Hashing.h3(ch, hashSize);
		
		matrix[0][h0]++;
		matrix[1][h1]++;
		matrix[2][h2]++;
		matrix[3][h3]++;
	}
	
	public int occurence(byte ch) {
		int h0 = Hashing.h0(ch, hashSize);
		int h1 = Hashing.h1(ch, hashSize);
		int h2 = Hashing.h2(ch, hashSize);
		int h3 = Hashing.h3(ch, hashSize);

		int[] values = { matrix[0][h0], matrix[1][h1], matrix[2][h2],
				matrix[3][h3] };
		int minValue = values[0];
		for (int i = 0; i < values.length; i++) {
			if (values[i] < minValue) {
				minValue = values[i];
			}
		}

		return minValue;
	}
	
	public void show() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<hashSize; j++) {
				System.out.printf("%d  ",matrix[i][j]);
			}
			System.out.println();
		}
	}

}
