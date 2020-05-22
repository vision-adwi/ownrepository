package com.datastructure.queue;

public class LinearQueue {
	int queue[];
	int head;
	int tail;
	
	public LinearQueue(int size) {
		queue = new int[size];
		head = -1;
		tail = -1;
	}
	
	public void enqueue(int item) {
		if (isFull()) {
			System.out.println("Queue is full. No new item can be added.");
		} else {
			queue[++tail] = item;
		}
	}
	
	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty. No item is there to return.");
			return Integer.MIN_VALUE;
		} else {
			int item = queue[++head];
			if (tail == head) {
				head = -1;
				tail = -1;
			}
			return item;
		}
	}
	
	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty. No item is there to return.");
			return Integer.MIN_VALUE;
		} else {
			return queue[head + 1];
		}
	}
	
	public boolean isFull() {
		if (tail >= queue.length -1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		if (tail == -1) {
			return true;
		} else {
			return false;
		}
	}

}
