package com.datastructure.arrays;

public class TwoDimensionArray {
	int rowSize;
	int columnSize;
	int[][] arr;
	
	TwoDimensionArray() {
	}

	TwoDimensionArray(int rowSize, int columnSize) {
		this.rowSize = rowSize;
		this.columnSize = columnSize;
		arr = new int[rowSize][columnSize];
		for (int n = 0; n < this.rowSize; n++) {
			for (int m = 0; m < this.columnSize; m++) {
				arr[n][m] = Integer.MIN_VALUE;
			}
		}
	}
	
	public void instatantiate(int rowSize, int columnSize) {
		arr = new int[rowSize][columnSize];
	}

	//Traversal - O(nm)
	public void initialize(int initialValue) {
		Long startTime = System.nanoTime();
		for (int n = 0; n < this.rowSize; n++) {
			for (int m = 0; m < this.columnSize; m++) {
				arr[n][m] = Integer.MIN_VALUE;
			}
		}
		Long endTime = System.nanoTime();
		System.out.println("Initialization Time - " + (endTime - startTime) / 1000);
	}
	
	//Insertion - O(1)
	public void insert(int row, int column, int value) {
		if ((row < this.rowSize && column < this.columnSize)
				&& (arr[row][column] == Integer.MIN_VALUE)) {
			arr[row][column] = value;
		}
	}
	
	//Access - O(1)
	public int access(int row, int column) {
		if ((row < this.rowSize && column < this.columnSize)
				&& (arr[row][column] != Integer.MIN_VALUE)) {
			return arr[row][column];
		}
		else {
			return Integer.MIN_VALUE;
		}
	}
	
	//Search - O(nm)
	public void search(int value) {
		for (int n = 0; n < this.rowSize; n++) {
			for (int m = 0; m < this.columnSize; m++) {
				if(arr[n][m] == value) {
					System.out.println(value + " is found in " + "row:" + n + " column:" + m);
					break;
				}
			}
		}
	}
	
	//Delete - O(1)
	public void delete(int row, int column) {
		if ((row < this.rowSize && column < this.columnSize)
				&& (arr[row][column] != Integer.MIN_VALUE)) {
			arr[row][column] = Integer.MIN_VALUE;
		}
	}

}
