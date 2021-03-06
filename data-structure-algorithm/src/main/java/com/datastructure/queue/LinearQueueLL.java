package com.datastructure.queue;

import com.datastructure.stack.Node;
public class LinearQueueLL {
	Node head = null;
	Node tail = null;
	
	public void enqueue(int item) {
		Node theNode = new Node();
		theNode.value = item;
		
		//When queue is empty
		if( tail == null ) {
			head = theNode;
			tail = theNode;
		}
		else {
			tail.next = theNode;
			tail = theNode;
		}
	}

	public int dequeue() {
		//When queue is empty
		if( isEmpty() ) {
			System.out.println("Queue is empty. Nothing can be returned.");
			return Integer.MIN_VALUE;
		}
		
		int theValue = head.value;
		//When queue has only one element
		if( head == tail ) {
			head = null;
			tail = null;
		}
		else {
			head = head.next;
		}
		return theValue;
	}
	
	public int peek() {
		//When queue is empty
		if( isEmpty() ) {
			System.out.println("Queue is empty. Nothing can be returned.");
			return Integer.MIN_VALUE;
		}
		else {
			return head.value;
		}
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void kill() {
		head = null;
		tail = null;
	}

}
