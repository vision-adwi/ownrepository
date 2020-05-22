package com.pattern.behavioral.memento;

public class Stack {
	Node top = null;

	public Stack() {
	}

	public void push(Object obj) {
		Node theNode = new Node();

		theNode.nodeValue = obj;
		theNode.next = top;
		top = theNode;
	}

	public Object pop() {
		Object nodeValue = null;
		if (top != null) {
			nodeValue = top.nodeValue;
			top = top.next;
		}
		return nodeValue;
	}

	class Node {
		Object nodeValue;
		Node next;
	}
}
