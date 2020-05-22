package com.learning.lang.concurrency.producerconsumer.v2;

public class ConcurrentQueue {
	int queue[];
	int head;
	int tail;
	
	public ConcurrentQueue(int size) {
		queue = new int[size];
		head = -1;
		tail = -1;
	}
	
	public synchronized void enqueue(int item) throws InterruptedException {
		if (isFull()) {
			System.out.println("Queue is full. Item " + item + " can not be added. WAIT !!!");
			wait();
		}
		tail = (tail + 1) % queue.length;
		queue[tail] = item;
		
		notifyAll();
	}
	
	public synchronized int dequeue() throws InterruptedException {
		if (isEmpty()) {
			System.out.println("Queue is empty. No item is there to return. WAIT !!!");
			wait();
		}
		head = (head + 1) % queue.length;
		int item = queue[head];
		if (head == tail) {
			head = -1;
			tail = -1;
		}
		notifyAll();
		
		return item;
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
