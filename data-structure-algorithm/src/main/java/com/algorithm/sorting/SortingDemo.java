package com.algorithm.sorting;

import java.util.Random;

public class SortingDemo {
	/*
	 * Sorting can be classified on the basis of 'space' and 'stability'. -
	 * In-place - Out-of-place - Stable - Un-stable
	 * 
	 * Terminology 
	 * # Increasing order 
	 * # Decreasing order 
	 * # Non-increasing order(similar to decreasing order which allows duplicate as well.) 
	 * # Non-decreasing order(similar to increasing order which allows duplicate
	 * as well.)
	 */
	public static void main(String[] args) {
		int[] unsorted = generateData(500);
		System.out.println("Unsorted Data");
		print(unsorted);

		AbstractSort bubble = new BubbleSort(unsorted);
		print(bubble.sort());

		AbstractSort selection = new SelectionSort(unsorted);
		print(selection.sort());

		AbstractSort insertion = new InsertionSort(unsorted);
		print(insertion.sort());

		AbstractSort merge = new MergeSort(unsorted);
		print(merge.sort());

		AbstractSort quickSort = new QuickSort(unsorted);
		print(quickSort.sort());

		AbstractSort heapSort = new HeapSort(unsorted);
		print(heapSort.sort());
	}

	private static void print(int[] elements) {
		System.out.print("[");
		for (int element : elements) {
			System.out.print(element + " ");
		}
		System.out.println("]\n");
	}
	
	private static int[] generateData(int size) {
		int[] data = new int[size];
		
		Random random = new Random();
		int number;
		for(int i=0; i<size; i++) {
			number = Math.abs(random.nextInt()) % (size * 10);
			data[i] = number;
		}
		
		return data;
		
	}

}
