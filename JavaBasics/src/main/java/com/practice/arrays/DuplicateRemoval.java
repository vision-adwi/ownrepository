package com.practice.arrays;

public class DuplicateRemoval {
	int[] sortedData = {10, 12, 23, 23, 23, 26, 30, 30, 33, 36, 40, 45, 50, 50, 57, 65, 65, 65};
	int arraySize;
	
	public DuplicateRemoval() {
		arraySize = sortedData.length;
	}
	
	public void remove() {
		arraySize = 0;
		int predecessor = Integer.MAX_VALUE;
		for(int value: sortedData) {
			if(value != predecessor) {
				sortedData[arraySize++] = value;
				predecessor = value;
			}
		}
	}
	
	public void print() {
		System.out.print("[ ");
		for (int i = 0; i < arraySize; i++) {
			System.out.print(sortedData[i] + " ");

		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		DuplicateRemoval removal = new DuplicateRemoval();
		removal.print();
		removal.remove();
		removal.print();
	}

}
