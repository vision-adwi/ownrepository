package com.datastructure.tree.common;

public class TreeNode<T> {
	private T data;
	private final TreeNode<T> parent;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;

	public TreeNode(T theData, TreeNode<T> theParent) {
		this.data = theData;
		this.parent = theParent;
	}
	
	public void setLeftChild(TreeNode<T> theLeftChild) {
		this.leftChild = theLeftChild;
	}
	
	public void setRightChild(TreeNode<T> theRightChild) {
		this.rightChild = theRightChild;
	}
	
	public void setData(T theData) {
		this.data = theData;
	}
	
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}
	
	public TreeNode<T> getRightChild() {
		return rightChild;
	}
	
	public TreeNode<T> getParent() {
		return parent;
	}
	
	public T getData() {
		return data;
	}

}
