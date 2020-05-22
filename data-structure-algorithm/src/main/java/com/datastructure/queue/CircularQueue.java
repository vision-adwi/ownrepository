package com.datastructure.queue;

public class CircularQueue {
	Object queue[];
	int head;
	int tail;
	
	public CircularQueue() {
		this(128);
	}
	
	public CircularQueue(int size) {
		queue = new Object[size];
		head = -1;
		tail = -1;
	}
	
	public void enqueue(Object item) {
		if (isFull()) {
			System.out.println("Queue is full. Item " + item + " can not be added.");
		} else {
			tail = (tail + 1) % queue.length;
			queue[tail] = item;
		}
	}
	
	public Object dequeue() {
		if (isEmpty()) {
			//System.out.println("Queue is empty. No item is there to return.");
			return null;
		} else {
			head = (head + 1) % queue.length;
			Object item = queue[head];
			if (head == tail) {
				head = -1;
				tail = -1;
			}
			return item;
		}
	}
	
	public Object peekInQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty. No item is there to return.");
			return null;
		} else {
			return queue[head + 1];
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
