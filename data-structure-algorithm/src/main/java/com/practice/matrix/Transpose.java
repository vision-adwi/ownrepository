package com.practice.matrix;
import java.util.Scanner;
/*
Leetcode#867. Transpose Matrix
Given a matrix A, return the transpose of A.
The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
*/
public class Transpose {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Row length: ");
		int row = scanner.nextInt();
		System.out.print("Column length: ");
		int column = scanner.nextInt();
		
		int[][] matrix = new int[row][column];
		Util.takeMatrixInput(matrix, scanner);
		System.out.println("Source Matrix");
		Util.display(matrix);
		
		if(row == column) //Square matrx
			transInMemSquare(matrix);
		else
			matrix = transpose(matrix);
		
		System.out.println("After transpose");
		Util.display(matrix);

		scanner.close();
	}
	
	private static void transInMemSquare(int[][] intArray) {
		int tmp;
		for(int i = 0; i < intArray.length; i++) {
			for(int j = i + 1; j < intArray[0].length; j++) {
				tmp = intArray[i][j];
				intArray[i][j] = intArray[j][i];
				intArray[j][i] = tmp;
			}
		}
	}
	
    private static int[][] transpose(int[][] A) {
        int[][] trans = new int[A[0].length][A.length];
        
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < A[0].length; j++)
                trans[j][i] = A[i][j];
        
        return trans;
    }
}
