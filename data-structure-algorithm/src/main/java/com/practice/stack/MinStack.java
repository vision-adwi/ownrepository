package com.practice.stack;
/*
Leetcode#155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/
public class MinStack {
	private long stack[];
	private int top;
	long minElement;

    /** initialize your data structure here. */
    public MinStack() {
    	stack = new long[1000];
		top = -1;
    }
    
    public void push(int x) {
    	if (top == -1) {
			minElement = x;
			stack[++top] = x;
		} else if (x < minElement) {
			long newItem = (2 * x) - minElement;
			minElement = x;
			stack[++top] = newItem;
		} else {
			stack[++top] = x;
		}
    }
    
    public void pop() {
		long element = stack[top--];
		if(element < minElement) {
			minElement = (2 * minElement) - element;
		}
    }
    
    public int top() {
		long element = stack[top];
		if(element < minElement) {
			element = minElement;
		}
		return (int)element;
    }
    
    public int getMin() {
        return (int)minElement;
    }
}
