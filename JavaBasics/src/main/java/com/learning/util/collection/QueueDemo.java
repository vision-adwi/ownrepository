package com.learning.util.collection;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class QueueDemo {
	/*
	** offer	add 		put
	** poll		remove		take
	** peek		element
	*/
	public static void main(String[] args) {
		priorityQueueTest();

	}
	
	//Piority queue is implementation of heap data structure
	public static void priorityQueueTest() {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		queue.add(44);
		queue.add(50);
		queue.add(40);
		queue.add(10);
		queue.add(55);
		queue.add(65);
		queue.add(70);

		System.out.println("queue.poll(): " + queue.poll());
	}
	
	/**
	 * This is a classic "bounded buffer", in which a fixed-sized array holds elements 
	 * inserted by producers and extracted by consumers.  Once created, the capacity 
	 * cannot be changed.  Attempts to "put" an element into a full queue will result 
	 * in the operation blocking; attempts to "take" an element from an empty queue will similarly block.
	 **/
	public static void arrayBlockingQueueTest() {
		ArrayBlockingQueue queue = new ArrayBlockingQueue(2);
	}
	
	public static void linkedBlockingQueueTest() {
		LinkedBlockingQueue queue = new LinkedBlockingQueue(2);
	}
	
	/**
	 * A BlockingQueue queue in which each insert operation must wait for 
	 * a corresponding remove operation by another thread, and vice versa.  
	 * A synchronous queue does not have any internal capacity, not even a
	 * capacity of one. 
	 */
	public static void synchronousQueueTest() {
		SynchronousQueue queue = new SynchronousQueue();
	}

}
