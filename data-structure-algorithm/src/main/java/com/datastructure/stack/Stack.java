package com.datastructure.stack;

public class Stack implements IStack{
	private int stack[];
	private int top;

	public Stack(int size) {
		stack = new int[size];
		top = -1;
	}

	@Override
	public void push(int item) {
		if (top < stack.length -1) {//isFull?
			stack[++top] = item;
		} else {
			System.out.println("Stack is full.");
		}
	}

	@Override
	public int pop() {
		if (!isEmpty()) {
			return stack[top--];
		} else {
			System.out.println("Stack is empty.");
			return Integer.MIN_VALUE;
		}
	}

	@Override
	public int peek() {
		if (!isEmpty()) {
			return stack[top];
		} else {
			System.out.println("Stack is empty.");
			return Integer.MIN_VALUE;
		}
	}

	@Override
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void kill() {
		top = -1;
	}

}
