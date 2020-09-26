package com.practice.util;
public class DLLNode {
	public int key;
	public int val;
	public DLLNode previous;
	public DLLNode next;

	public DLLNode() {
	}

	public DLLNode(int val) {
		this.val = val;
	}

	public DLLNode(int key, int val, DLLNode next, DLLNode previous) {
		this.key = key;
		this.val = val;
		this.next = next;
		this.previous = previous;
	}
}

