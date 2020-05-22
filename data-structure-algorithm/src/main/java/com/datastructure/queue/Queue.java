package com.datastructure.queue;

public interface Queue {
	void enqueue(int item);
	int dequeue();
	int peek();
	boolean isEmpty();
	void kill();

}
