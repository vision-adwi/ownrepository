package com.practice.matrix;

import java.util.Scanner;

public class Equality {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the the numer of rows for matrix A: ");
		int m = scanner.nextInt();
		System.out.print("Enter the the numer of columns for matrix A: ");
		int n = scanner.nextInt();
		System.out.print("Enter the the numer of rows for matrix B: ");
		int p = scanner.nextInt();
		System.out.print("Enter the the numer of columns for matrix B: ");
		int q = scanner.nextInt();

		int[][] matrixA = new int[m][n];
		int[][] matrixB = new int[p][q];
		
		System.out.println("Enter the elements of Matrix A");
		Util.takeMatrixInput(matrixA, scanner);
		
		System.out.println("Enter the elements of Matrix B");
		Util.takeMatrixInput(matrixB, scanner);

		System.out.println("Matrix A");
		Util.display(matrixA);
		
		System.out.println("Matrix B");
		Util.display(matrixB);
		
		System.out.println("These matrices " +
				(equal(matrixA, matrixB) ? "are" : "ain't") + " equal.");

		scanner.close();
	}
	
	public static boolean equal(int[][] matrixA, int[][] matrixB) {
		int rows = matrixA.length;
		int columns = matrixA[0].length;
		if((rows != matrixB.length) || (columns != matrixB[0].length)) {
			return false;
		}
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(matrixA[i][j] != matrixB[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}

}
