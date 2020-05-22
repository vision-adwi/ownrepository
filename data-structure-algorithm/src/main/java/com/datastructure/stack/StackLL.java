package com.datastructure.stack;

public class StackLL implements IStack{
	private Node top;

	@Override
	public void push(int nodeValue) {
		Node node = new Node();
		node.value = nodeValue;
		
		node.next = top;
		top = node;
	}
	
	@Override
	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty.");
			return Integer.MIN_VALUE;
		} else {
			Node node = top;
			top = top.next;
			return node.value;
		}
	}
	
	@Override
	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty.");
			return Integer.MIN_VALUE;
		} else {
			return top.value;
		}
	}
	
	@Override
	public boolean isEmpty() {
		if (top == null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void kill() {
		top = null;
	}

}
