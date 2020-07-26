package com.practice.matrix;
import java.util.Scanner;

public class Sparse {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the the size of matrix\nRows: ");
		int rows = scanner.nextInt();
		System.out.print("Columns: ");
		int columns = scanner.nextInt();
		int[][] intArray = new int[rows][columns];
		Util.takeMatrixInput(intArray, scanner);
		Util.display(intArray);
		System.out.println("This matrix is" +
				(isSparse(intArray) ? " " : " not ") + "a Sparse Matrix !!!");
		scanner.close();
	}
	
	private static boolean isSparse(int[][] intArray) {
		int rows = intArray.length;
		int columns = intArray[0].length;
		int count = 0;
		int threshold = (rows * columns) / 2;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if((intArray[i][j] == 0) && (++count > threshold))
					return true;
			}
		}
		return false;
	}
}
