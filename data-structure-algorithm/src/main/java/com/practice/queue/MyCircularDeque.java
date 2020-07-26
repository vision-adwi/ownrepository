package com.practice.queue;
/*
Leetcode#641. Design Circular Deque
*/
public class MyCircularDeque {
    int[] queue;
    int length;
    int front, rear;
    public MyCircularDeque(int k) {
    	length = k;
        queue = new int[length];
        front = rear = -1;
    }

    public boolean insertFront(int value) {
        boolean flag = false;
        if(!isFull()) {
        	if(front == -1) {//Initial condition
        		front = length - 1;
        		if(rear == -1)
                    rear  = length - 1;
        	}
        	queue[front] = value;
        	front = (front == 0) ? length - 1 : --front;
        	flag = true;
        }
        
        return flag;
    }

    public boolean insertLast(int value) {
    	boolean flag = false;
    	if(!isFull()) {
    		rear = (rear + 1) % length;
    		queue[rear] = value;
    		if(front == -1)
    			front = length - 1;
    		flag = true;
    	}
        
    	return flag;
    }

    public boolean deleteFront() {
        boolean flag = false;
        if(!isEmpty()) {
        	front = (front + 1) % length;
        	if(front == rear)
        		front = rear = -1;
        	flag = true;
        }
        
        return flag;
    }

    public boolean deleteLast() {
        boolean flag = false;
        if(!isEmpty()) {
        	rear = (rear == 0) ? length - 1 : --rear;
        	if(front == rear)
        		front = rear = -1;
        	flag = true;
        }
        
        return flag;
    }

    public int getFront() {
    	if(isEmpty())
    		return -1;
    	else
    		return queue[(front + 1) % length];
    }

    public int getRear() {
    	if(isEmpty())
    		return -1;
    	else
    		return queue[rear];
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public boolean isFull() {
    	if(isEmpty())
    		return false;
    	else
    		return (front + 1) % length == (rear + 1) % length;
        
    }
    
    public static void main(String[] s) {
    	MyCircularDeque deque = new MyCircularDeque(8);
    }

}
