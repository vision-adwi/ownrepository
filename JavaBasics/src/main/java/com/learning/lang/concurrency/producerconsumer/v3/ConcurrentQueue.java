package com.learning.lang.concurrency.producerconsumer.v3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentQueue {
	private int queue[];
	private int head;
	private int tail;
	private Lock lock;
	private Condition isEmpty;
	private Condition isFull;
	
	public ConcurrentQueue(int size) {
		queue = new int[size];
		head = tail = -1;
		lock = new ReentrantLock();
		isEmpty = lock.newCondition();
		isFull = lock.newCondition();
	}
	
	public void enqueue(int item) throws InterruptedException {
		lock.lock();
		if (isFull()) {
			System.out.println("Queue is full. Item " + item + " can not be added. WAIT !!!");
			isFull.await();
		}
		tail = (tail + 1) % queue.length;
		queue[tail] = item;
		
		isEmpty.signal();
		lock.unlock();
	}
	
	public int dequeue() throws InterruptedException {
		lock.lock();
		if (isEmpty()) {
			System.out.println("Queue is empty. No item is there to return. WAIT !!!");
			isEmpty.await();
		}
		head = (head + 1) % queue.length;
		int item = queue[head];
		if (head == tail) { //is Empty?
			head = tail = -1;
		}
		isFull.signal();
		lock.unlock();
		
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
