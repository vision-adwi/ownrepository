package com.datastructure.heap;

public class HeapTest {

	public static void main(String[] args) {
		BinaryMaxHeap maxHeap = new BinaryMaxHeap(7);
		
		maxHeap.insert(44);
		maxHeap.insert(50);
		maxHeap.insert(40);
		maxHeap.insert(55);
		maxHeap.insert(65);
		maxHeap.insert(70);
		maxHeap.insert(10);
		System.out.println(maxHeap.extract());
		System.out.println(maxHeap.extract());
		System.out.println(maxHeap.extract());
		System.out.println(maxHeap.extract());

	}

}
