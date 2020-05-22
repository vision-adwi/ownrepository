package com.practice.arrays;

public class Removal {
	int[] values = {23, 12, 23, 23, 23, 23, 28, 23, 23, 10, 15, 23, 12, 27, 57, 40, 30, 23};
	int arraySize;
	
	public Removal() {
		arraySize = values.length;
	}
	
	public void remove(int data) {
		arraySize = 0;
		for(int value: values) {
			if(value != data) {
				values[arraySize++] = value;
			}
		}
	}
	
	public void print() {
		System.out.print("[ ");
		for (int i = 0; i < arraySize; i++) {
			System.out.print(values[i] + " ");

		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		Removal removal = new Removal();
		removal.print();
		removal.remove(23);
		
		removal.print();
	}
}
