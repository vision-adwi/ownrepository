package com.learning.lang.concurrency.producerconsumer;

public class Queue {
	int queue[];
	int head;
	int tail;
	
	public Queue(int size) {
		queue = new int[size];
		head = -1;
		tail = -1;
	}
	
	public void enqueue(int item) {
		if (isFull()) {
			System.out.println("Queue is full. Item " + item + " can not be added.");
		} else {
			tail = (tail + 1) % queue.length;
			queue[tail] = item;
		}
	}
	
	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty. No item is there to return.");
			return Integer.MIN_VALUE;
		} else {
			head = (head + 1) % queue.length;
			int item = queue[head];
			if (head == tail) {
				head = -1;
				tail = -1;
			}
			return item;
		}
	}

	public boolean isFull() {
		if (isEmpty()) {
			return false;
		}
		if (((tail + 1) % queue.length) == ((head + 1) % queue.length)) {
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
