package com.practice.matrix;
import java.util.Scanner;

public class Multiplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the matrix dimensions for multiplication");
		System.out.print("Enter the the numer of rows for matrix A: ");
		int m = scanner.nextInt();
		System.out.print("Enter the the numer of columns for matrix A: ");
		int n = scanner.nextInt();
		System.out.print("Enter the the numer of columns for matrix B: ");
		int p = scanner.nextInt();
		
		int[][] matrixA = new int[m][n];
		int[][] matrixB = new int[n][p];
		//int[][] product = new int[m][p];
		
		System.out.println("Enter the elements of Matrix A");
		Util.takeMatrixInput(matrixA, scanner);
		
		System.out.println("Enter the elements of Matrix B");
		Util.takeMatrixInput(matrixB, scanner);

		System.out.println("Matrix A");
		Util.display(matrixA);
		
		System.out.println("Matrix B");
		Util.display(matrixB);
		
		System.out.println("Product");
		int[][] product = product(matrixA, matrixB);
		Util.display(product);
	}

	private static int[][] product(int[][] matrixA, int[][] matrixB) {
		int rows = matrixA.length;
		int cols = matrixB[0].length;
		
		int[][] product = new int[rows][cols];
		for(int row = 0; row < rows; row++) {
			for(int column = 0; column < cols; column++) {
				product[row][column] = calculate(matrixA, matrixB, row, column);
			}
		}
		
		return product;
	}
	
	private static int calculate(int[][] matrixA, int[][] matrixB, int row, int column) {
		int sum = 0;
		for(int i = 0; i < matrixA[0].length; i++) {
			sum = sum + (matrixA[row][i] * matrixB[i][column]); 
		}
		return sum;
	} 
}
