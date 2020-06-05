package com.learning.util.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class QueueDemo {
	/*
	** offer 	-	true / false
	** add 		-	true / IllegalStateException("Queue full")
	** put		-	void / wait-state
	*  
	** poll		-	E / null
	** remove	-	E / NoSuchElementException()	
	** take		- 	E / wait-state
	*
	*
	** peek		-	E / null	
	** element	-	E / NoSuchElementException()
	*/
	public static void main(String[] args) {
		priorityQueueTest();

	}
	
	//Priority queue is implementation of heap data structure
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
	
	/**
	 * Resizable-array implementation of the {@link Deque} interface.  Array
	 * deques have no capacity restrictions; they grow as necessary to support
	 * usage.  They are not thread-safe;
	 */
	public static void arrayDequeueTest() {
		Queue queue = new ArrayDeque();
	}

}
