package com.datastructure.tree.redblack;

public class RBNode {
	public static boolean RED = true;
	public static boolean BLACK = false;
	
	private int key;
	private RBNode parent;
	private RBNode left;
	private RBNode right;
	private boolean color;
	
	public RBNode(RBNode theParent, int theKey) {
		this.parent = theParent;
		this.key = theKey;
		this.color = RBNode.RED;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public RBNode getParent() {
		return parent;
	}
	public void setParent(RBNode parent) {
		this.parent = parent;
	}
	public RBNode getLeft() {
		return left;
	}
	public void setLeft(RBNode left) {
		this.left = left;
	}
	public RBNode getRight() {
		return right;
	}
	public void setRight(RBNode right) {
		this.right = right;
	}
	public boolean getColor() {
		return color;
	}
	public void setColor(boolean color) {
		this.color = color;
	}

}
