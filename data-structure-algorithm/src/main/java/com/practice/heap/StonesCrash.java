package com.practice.heap;
/*
Leetcode#1046. Last Stone Weight
We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
*/
public class StonesCrash {

	public static void main(String[] args) {
		//int[] stones = {5, 9, 3, 6, 2, 7, 11, 13, 15, 4};
		int[] stones = {9, 3, 2, 10};
		MaxHeap heap = new MaxHeap(stones.length);
		for(int stone:stones) {
			heap.insert(stone);
		}
		int x;
		int y;
		while(heap.size > 1) {
			x = heap.extract();
			y = heap.extract();
			if(x != y) {
				int diff = Math.abs( x- y);
				heap.insert(diff);
			}
		}
		
		if(heap.size == 1)
			System.out.println(heap.extract());
		else
		    System.out.println(0);

	}

}

class MaxHeap {
	int[] heapArray;
	int size = 0;
	MaxHeap(int size) {
		heapArray = new int[size + 1];
	}
	
	public void insert(int element) {
		heapArray[++size] = element;
		
		int tmp;
		for(int current = size, parent = current / 2;
				current > 1 && heapArray[current] > heapArray[parent];)
		{
			tmp = heapArray[current];
			heapArray[current] = heapArray[parent];
			heapArray[parent] = tmp;
			
			current = parent;
			parent = current / 2;
		}
	}
	
	public int extract() {
		int returnValue = heapArray[1];
		heapArray[1] = heapArray[size--];
		
		int current = 1;
		int next;
		int tmp;
		while(current <= (size / 2)) {
			next = current * 2;
			if(((next + 1) <= size) && (heapArray[next] < heapArray[next + 1])) {
				next = next + 1;
			}
			if(heapArray[next] > heapArray[current]) {
				tmp = heapArray[next];
				heapArray[next] = heapArray[current];
				heapArray[current] = tmp;
			}
			else {
				break;
			}
			current = next;
		}
		
		return returnValue;
	}
	
	
}
