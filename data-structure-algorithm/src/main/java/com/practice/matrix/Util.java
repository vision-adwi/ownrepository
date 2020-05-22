package com.practice.matrix;

import java.util.Scanner;

public class Util {
	public static void display(int[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void takeMatrixInput(int[][] matrix, Scanner scanner) {
		int row = matrix.length;
		int column = matrix[0].length;
		for(int i = 0; i < row; i++) {
			System.out.println("Enter the row : " + i);
			for(int j = 0; j < column; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
	}

}
