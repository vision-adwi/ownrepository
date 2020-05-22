package com.datastructure.tree.bst;

import com.datastructure.tree.BinaryTree;
import com.datastructure.tree.common.TreeNode;
import com.datastructure.tree.common.SearchType;

public class BinarySearchTree<T> extends BinaryTree<T> {
	public BinarySearchTree(T value) {
		super(value);
	}
	
	@Override
	public void insert(T value) {
		insertInBST(this.root, value);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void insertInBST(TreeNode<T> node, T value) {
		Comparable compValue = (Comparable) value;
		int comp = compValue.compareTo(node.getData());

		TreeNode<T> childNode = null;
		if (comp <= 0) {
			if ((childNode = node.getLeftChild()) == null) {
				node.setLeftChild(new TreeNode<>(value, node));
				return;
			}
		} else {
			if ((childNode = node.getRightChild()) == null) {
				node.setRightChild(new TreeNode<>(value, node));
				return;
			}
		}
		insertInBST(childNode, value);
	}
	
	public boolean search(T value) {
		return super.search(value, SearchType.DFS);
	}
	
	@Override
	public boolean depthFirstSearch(TreeNode<T> node, T value) {
		if (searchNode(node, value) != null)
			return true;

		return false;
	}

	@Override
	public boolean delete(T value) {
		TreeNode<T> nodeToBeDeleted = searchNode(this.root, value);
		if (nodeToBeDeleted == null) {
			return false;
		}

		//Node to be deleted has both children
		if ((nodeToBeDeleted.getLeftChild() != null) && (nodeToBeDeleted.getRightChild() != null)) {
			deleteNodeWithTwoChildren(nodeToBeDeleted);
		} else { //Node to be deleted has either one child or no child
			TreeNode<T> child = null;
			if((child = nodeToBeDeleted.getLeftChild()) == null) {
				child = nodeToBeDeleted.getRightChild();
			}
			deleteNode(nodeToBeDeleted, child);
		}
		return true;
	}
	
	public int diff() {
		return difference(this.root);
	}
	
	private int difference(TreeNode<T> node) {
		if(node == null) {
			return -1;
		}
		else {
			int leftHeight = difference(node.getLeftChild());
			int rightHeight = difference(node.getRightChild());
			int difference = (leftHeight > rightHeight) ? (leftHeight - rightHeight) : (rightHeight - leftHeight);
			System.out.println("Node: " + node.getData() + " - " + difference);
			return difference;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private TreeNode<T> searchNode(TreeNode<T> node, T value) {
		if (node == null) {
			return null;
		} else {
			Comparable compValue = (Comparable) value;
			int comp = compValue.compareTo(node.getData());

			if (comp == 0) {
				return node;
			}

			TreeNode<T> childNode = null;
			if (comp < 0) {
				childNode = node.getLeftChild();
			} else {
				childNode = node.getRightChild();
			}
			
			return searchNode(childNode, value);
		}
	}

	private void deleteNodeWithTwoChildren(TreeNode<T> node) {
		TreeNode<T> successor = node.getRightChild();
		while (successor.getLeftChild() != null) {
			successor = successor.getLeftChild();
		}
		node.setData(successor.getData());
		deleteNode(successor, successor.getRightChild());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void deleteNode(TreeNode<T> node, TreeNode<T> child) {
		TreeNode<T> parent = node.getParent();
		Comparable comparable = (Comparable) parent.getLeftChild().getData();
		if (comparable.compareTo(node.getData()) == 0) {
			parent.setLeftChild(child);
		} else {
			parent.setRightChild(child);
		}
	}
}
