package com.datastructure.stack;

import com.datastructure.queue.CircularQueue;
import com.datastructure.queue.CircularQueueLL;
import com.datastructure.queue.LinearQueue;
import com.datastructure.queue.LinearQueueLL;

public class Driver {

	public static void main(String[] args) {
		//stackTest();
		//linearQueueTest();
		//linearQueueLLTest();
		circularQueueLLTest();

	}
	
	private static void stackTest() {
		Stack stack = new Stack(5);
		stack.pop();
		
		stack.push(10);
		System.out.println(stack.pop());
		stack.pop();
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		System.out.println(stack.pop());
		stack.push(70);
		stack.push(80);
	}
	
	private static void linearQueueTest() {
		/*CircularQueue queue = new CircularQueue(5);
		queue.dequeue();
		queue.enqueue(5);
		queue.enqueue(15);
		queue.enqueue(25);
		queue.enqueue(35);
		queue.enqueue(45);
		queue.enqueue(55);
		System.out.println(queue.dequeue());
		queue.enqueue(55);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue(65);
		System.out.println(queue.dequeue());*/
		/*System.out.println(queue.dequeue());
		
		queue.dequeue();*/
	}
	
	private static void linearQueueLLTest() {
		LinearQueueLL queue = new LinearQueueLL();
		
		System.out.println("Dequeue from empty queue*****");
		queue.dequeue();
		System.out.println("Enqueue one item*****");
		queue.enqueue(5);
		System.out.println("Dequeue from the only one item queue*****");
		System.out.println(queue.dequeue());
		System.out.println("Dequeue from empty queue*****");
		queue.dequeue();
		System.out.println("Enqueue two items*****");
		queue.enqueue(55);
		queue.enqueue(65);
		System.out.println("Dequeue from queue*****");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println("Enqueue one item*****");
		queue.enqueue(65);
		System.out.println("Peek from queue*****");
		System.out.println(queue.peek());
	}
	
	private static void circularQueueLLTest() {
		CircularQueueLL queue = new CircularQueueLL();
		
		System.out.println("Dequeue from empty queue*****");
		queue.dequeue();
		System.out.println("Enqueue one item*****");
		queue.enqueue(5);
		System.out.println("Dequeue from the only one item queue*****");
		System.out.println(queue.dequeue());
		System.out.println("Dequeue from empty queue*****");
		queue.dequeue();
		System.out.println("Enqueue two items*****");
		queue.enqueue(55);
		queue.enqueue(65);
		System.out.println("Dequeue from queue*****");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println("Enqueue one item*****");
		queue.enqueue(65);
		System.out.println("Peek from queue*****");
		System.out.println(queue.peek());
	}

}
