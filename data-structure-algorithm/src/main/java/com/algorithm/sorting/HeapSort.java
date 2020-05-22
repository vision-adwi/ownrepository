package com.algorithm.sorting;

import com.datastructure.heap.BinaryMaxHeap;

public class HeapSort extends AbstractSort {
	public HeapSort(int[] unsorted) {
		super(unsorted);
	}

	@Override
	protected void perform() {
		BinaryMaxHeap maxHeap = new BinaryMaxHeap(elements.length);
		for (int element : elements) {
			maxHeap.insert(element);
		}

		for (int index = 0; index < elements.length; index++) {
			elements[index] = maxHeap.extract();
		}
	}
	
	@Override
	protected String getSortName() {
		return "Heap Sort";
	}

}
