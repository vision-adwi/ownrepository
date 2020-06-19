package com.practice.queue;
/*
Leetcode#622. Design Circular Queue
*/
class MyCircularQueue {
    int[] queue;
    int front;
    int rear;
    public MyCircularQueue(int k) {
        queue = new int[k];
        front = -1;
        rear = -1;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
    	boolean isDone = false;
        if(!isFull()) {
        	rear = (rear + 1) % queue.length;
        	queue[rear] = value;
        	isDone = true;
        }
        
        return isDone;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
    	boolean isDone = false;
    	if(!isEmpty()) {
    		front = (front + 1) % queue.length;
    		
    		if(front == rear) {
    			front = -1;
    			rear = -1;
    		}
    		isDone = true;
    	}
    	
        return isDone;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
    	if(isEmpty())
    		return -1;
    	else
    		return queue[(front + 1) % queue.length];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
    	if(isEmpty())
    		return -1;
    	else
    		return queue[rear];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return rear == -1;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
    	if(isEmpty())
    		return false;
    	
        return ((front + 1) % queue.length) == ((rear + 1) % queue.length);
    }
}

