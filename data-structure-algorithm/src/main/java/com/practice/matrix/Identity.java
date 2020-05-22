package com.practice.matrix;
import java.util.Scanner;
public class Identity {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the the size of square matrix: ");
		int size = scanner.nextInt();
		int[][] squareMatrix = new int[size][size];
		Util.takeMatrixInput(squareMatrix, scanner);
		Util.display(squareMatrix);
		System.out.println("This matrix is" +
						(isIdentityMatrix(squareMatrix) ? " " : " not ") + "an Identity Matrix !!!");

		scanner.close();
	}

	private static boolean isIdentityMatrix(int[][] intArray) {
		int rows = intArray.length;
		int columns = intArray[0].length;
		
		boolean isIdentity = true;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (i == j) {
					if (intArray[i][i] != 1) {
						isIdentity = false;
						break;
					}
				} else if (intArray[i][j] != 0) {
					isIdentity = false;
					break;
				}
			}
		}
		return isIdentity;
	}
}
