package com.datastructure.heap;

public class BinaryMaxHeap {
	private int[] heap;
	private int size = 0;

	public BinaryMaxHeap(int heapSize) {
		heap = new int[heapSize + 1];
	}

	public void insert(int element) {
		if (isFull()) {
			System.out.println("Heap size is exhausted..");
			return;
		}

		heap[++size] = element;

		int tmp;
		for (int current = size, parent = size / 2; current > 1
				&& (heap[current] > heap[parent]);) {
			tmp = heap[current];
			heap[current] = heap[parent];
			heap[parent] = tmp;
			
			current = parent;
			parent = current / 2;
		}
	}

	public int extract() {
		if(isEmpty()) {
			System.out.println("No elements are there in heap..");
			return Integer.MAX_VALUE;
		}
		
		int returnValue = heap[1];
		heap[1] = heap[size];
		size--;

		int current = 1;
		int next;
		int tmp;
		// Heapify top to bottom
		while (current <= (size / 2)) {
			next = current * 2;
			if ((next + 1) <= size && heap[next + 1] > heap[next]) {
				next = (current * 2) + 1;
			}

			if (heap[current] < heap[next]) {
				tmp = heap[next];
				heap[next] = heap[current];
				heap[current] = tmp;

				current = next;
			} else {
				break;
			}
		}

		return returnValue;
	}
	
	public boolean isEmpty() {
		return size < 1;
	}
	
	public boolean isFull() {
		return (size >= heap.length - 1); 
	}

	public int size() {
		return this.size;
	}

	public int peek() {
		return heap[1];
	}
}
