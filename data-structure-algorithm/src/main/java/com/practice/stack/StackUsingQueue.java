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
    	Queue<Integer> tmp = new ArrayDeque<>();
    	while(queue.size() > 1) {
    		tmp.offer(queue.poll());
    	}
    	int top = queue.poll();
    	queue = tmp;
    	return top;
    }
}
