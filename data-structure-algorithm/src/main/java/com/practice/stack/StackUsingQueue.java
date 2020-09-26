package com.practice.stack;

import java.util.ArrayDeque;
import java.util.Queue;
/*
Leetcode#225. Implement Stack using Queues
*/
public class StackUsingQueue {
    Queue<Integer> queue;

    public StackUsingQueue() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

	public int pop() {
		return upsideDown();
	}

    public int top() {
    	int top = upsideDown();
    	queue.offer(top);

        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
    
    private int upsideDown() {
    	int size = queue.size();
    	while(size-- > 1) {
    		queue.offer(queue.poll());
    	}
    	
    	return queue.poll();
    }
    
    public static void main(String[] s) {
    	StackUsingQueue stack = new StackUsingQueue();
    	
    	stack.push(1);
    	stack.push(2);
    	stack.push(3);
    	stack.push(4);
    	stack.push(5);
    	
    	System.out.println(stack.pop());
    	System.out.println(stack.pop());
    }
}
