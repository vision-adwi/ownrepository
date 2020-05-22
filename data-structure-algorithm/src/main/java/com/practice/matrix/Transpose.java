package com.practice.matrix;
import java.util.Scanner;
public class Transpose {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the the size of square matrix: ");
		int size = scanner.nextInt();
		int[][] squareMatrix = new int[size][size];
		Util.takeMatrixInput(squareMatrix, scanner);
		System.out.println("Source Matrix");
		Util.display(squareMatrix);
		transpose(squareMatrix);
		System.out.println("After transpose");
		Util.display(squareMatrix);

		scanner.close();
	}
	
	private static void transpose(int[][] intArray) {
		int rows = intArray.length;
		int columns = intArray[0].length;
		int tmp;
		for(int i = 0; i < rows; i++) {
			for(int j = i + 1; j < columns; j++) {
				tmp = intArray[i][j];
				intArray[i][j] = intArray[j][i];
				intArray[j][i] = tmp;
			}
		}
	}
}
