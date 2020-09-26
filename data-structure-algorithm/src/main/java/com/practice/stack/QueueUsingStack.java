package com.practice.stack;
/*
Leetcode#232. Implement Queue using Stacks
Implement the following operations of a queue using stacks.

-push(x) -- Push element x to the back of queue.
-pop() -- Removes the element from in front of queue.
-peek() -- Get the front element.
-empty() -- Return whether the queue is empty.
*/
import java.util.Stack;

public class QueueUsingStack {
	Stack<Integer> pushStack;
	Stack<Integer> popStack;
	
    /** Initialize your data structure here. */
    public QueueUsingStack() {
    	pushStack = new Stack<>();
    	popStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	pushStack.push(x);   
    }
    
    /** Removes the element from in front of queue and returns that element. */
	public int pop() {
		pour();

		return popStack.pop();
	}
    
    /** Get the front element. */
    public int peek() {
		pour();

		return popStack.peek();
    }
    
    private void pour() {
    	if (popStack.isEmpty()) {
			while (!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
		}
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	return popStack.isEmpty() && pushStack.isEmpty();  
    }

}
