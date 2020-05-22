package com.learning.util.collection;

public class SingleDimensionArray {
	int[] arr;
	
	SingleDimensionArray() {
	}

	SingleDimensionArray(int size) {
		arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.MIN_VALUE;
		}
	}
	
	public void instatantiate(int size) {
		arr = new int[size];
	}

	//Traversal - O(n)
	public void initialize(int initialValue) {
		Long startTime = System.nanoTime();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = initialValue++;
		}
		Long endTime = System.nanoTime();
		System.out.println("Initialization Time - " + (endTime - startTime) / 1000);
	}
	
	//Insertion - O(1)
	public void insert(int index, int value) {
		if (index < arr.length && arr[index] == Integer.MIN_VALUE) {
			arr[index] = value;
		}
	}
	
	//Access - O(1)
	public int access(int index) {
		if (index > arr.length || arr[index] == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		} else {
			return arr[index];
		}
	}
	
	//Search - O(n)
	public int search(int value) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == value) {
				return i;
			}
		}
		return Integer.MIN_VALUE;
	}
	
	//Delete - O(1)
	public void delete(int index) {
		if (index < arr.length && arr[index] != Integer.MIN_VALUE) {
			arr[index] = Integer.MIN_VALUE;
		}
	}
}
