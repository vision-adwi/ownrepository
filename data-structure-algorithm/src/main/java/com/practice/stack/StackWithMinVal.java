package com.practice.stack;

import com.datastructure.stack.Stack;

public class StackWithMinVal extends Stack {
	int minElement;

	public StackWithMinVal(int size) {
		super(size);
		minElement = Integer.MAX_VALUE;
	}

	@Override
	public void push(int item) {
		if (isEmpty()) {
			minElement = item;
		} else if (item < minElement) {
			int newItem = (2 * item) - minElement;
			minElement = item;
			item = newItem;
		}
		super.push(item);
	}
	
	@Override
	public int pop() {
		int element = super.pop();
		if(element < minElement) {
			int retVal = minElement;
			minElement = (2 * minElement) - element;
			element = retVal;
		}
		return element;
	}
	
	public int getMinElement() {
		return minElement;
	}

}
