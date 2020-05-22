package com.datastructure.tree;

import com.datastructure.queue.CircularQueue;
import com.datastructure.tree.common.TreeNode;
import com.datastructure.tree.common.SearchType;
import com.datastructure.tree.common.TraverseType;
/*
Tree Terminology
Root: Node with no parent
Edge: Link from Parent to Child
Leaf: Node with no children
Sibling: Children of same parent
Ancestor: means parent, grand-parent etc
Depth of node: Length of path from root to node
Height of node: Length of the path from that node to the deepest node
Height of tree: Same as height of root node
Depth of tree: Same as depth of root node(that is 0)

Predecessor: Predecessor of a node is the immediate previous node in the inorder traversal of the Binary Tree
Successor: Successor of a node is the immediate next node in the inorder traversal of the Binary Tree


Types of Binary Trees ******
- Strict Binary Tree: if each node has either 2 children or none.
- Full Binary Tree: if each non-leaf node has 2 children and all leaf nodes are at the same level.
- Complete Binary Tree: if all levels are completely filled except possibly the last level and the last level
all keys as left as possible

*/

public class BinaryTree<T> {
	protected final TreeNode<T> root;
	private int height;

	public BinaryTree(T value) {
		this.root = new TreeNode<>(value, null);
	}
	
	@SuppressWarnings("unchecked")
	public void insert(T data) {
		CircularQueue queue = new CircularQueue();
		queue.enqueue(this.root);
		
		Object element = null;
		while ((element = queue.dequeue()) != null) {
			TreeNode<T> node = (TreeNode<T>) element;
			if (node.getLeftChild() == null) {
				node.setLeftChild(new TreeNode<>(data, node));
				break;
			}
			if (node.getRightChild() == null) {
				node.setRightChild(new TreeNode<>(data, node));
				break;
			}
			
			enqueueChildren(queue, node);
		}
	}

	public boolean search(T value, SearchType type) {
		switch(type) {
		case BFS: 
			return breadthFirstSearch(value);
		case DFS:
			return depthFirstSearch(this.root, value);
		default:
			return false;
		}
	}
	
	public boolean depthFirstSearch(TreeNode<T> node, T value) {
		if (node != null) {
			if(comparison(node, value))
				return true;

			if (depthFirstSearch(node.getLeftChild(), value))
				return true;

			if (depthFirstSearch(node.getRightChild(), value))
				return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public boolean breadthFirstSearch(T value) {
		CircularQueue queue = new CircularQueue();
		queue.enqueue(this.root);

		Object element = null;
		while ((element = queue.dequeue()) != null) {
			if (comparison(element, value))
				return true;

			enqueueChildren(queue, (TreeNode<T>)element);
		}
		
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public boolean delete(T value) {
		TreeNode<T> lastVisitedNode = null;
		TreeNode<T> nodeToBeDeleted = null;
		
		CircularQueue queue = new CircularQueue();
		queue.enqueue(this.root);

		Object element = null;
		while ((element = queue.dequeue()) != null) {
			lastVisitedNode = (TreeNode<T>) element;
			if (comparison(element, value)) {
				nodeToBeDeleted = lastVisitedNode;
				//break;
			}

			enqueueChildren(queue, lastVisitedNode);
		}

		//If node is searched
		if (nodeToBeDeleted != null) {
			nodeToBeDeleted.setData(lastVisitedNode.getData());

			//Delete the last node in Binary Tree
			TreeNode<T> parent = lastVisitedNode.getParent();
			if (comparison(parent.getLeftChild(), lastVisitedNode.getData())) {
				parent.setLeftChild(null);
				return true;
			}
			if (comparison(parent.getRightChild(), lastVisitedNode.getData())) {
				parent.setRightChild(null);
				return true;
			}
		}

		return false;
	}
	
	//Wherever possible use queue level traversal than stack level traversal.
	//Queue based traversal is faster as compared to system level stack operation(recursion).
	public final void traverse(TraverseType type) {
		switch(type) {
		case PRE_ORDER:
			preOrderTraversal(this.root);
			break;
		case IN_ORDER:
			inOrderTraversal(this.root);
			break;
		case POST_ORDER:
			postOrderTraversal(this.root);
		case LEVEL_ORDER:
			levelOrderTraversal();
		}
	}
	
	public void preOrderTraversal(TreeNode<T> node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			preOrderTraversal(node.getLeftChild());
			preOrderTraversal(node.getRightChild());
		}
	}
	
	public void postOrderTraversal(TreeNode<T> node) {
		if (node != null) {
			postOrderTraversal(node.getLeftChild());
			postOrderTraversal(node.getRightChild());
			System.out.print(node.getData() + " ");
		}
	}
	
	public void inOrderTraversal(TreeNode<T> node) {
		if (node != null) {
			inOrderTraversal(node.getLeftChild());
			System.out.print(node.getData() + " ");
			inOrderTraversal(node.getRightChild());
		}
	}
	
	@SuppressWarnings("unchecked")
	public void levelOrderTraversal() {
		CircularQueue queue = new CircularQueue();
		queue.enqueue(this.root);

		Object element = null;
		while ((element = queue.dequeue()) != null) {
			TreeNode<T> node = (TreeNode<T>) element;
			System.out.print(node.getData() + " ");
			
			enqueueChildren(queue, node);
		}
	}
	
	public int heightOfTheTree() {
		findDepth(this.root, 0);
		
		return this.height;
	}
	
	private void findDepth(TreeNode<T> node, int depthCount) {
		if (node != null) {
			height = (depthCount++ > height) ? depthCount : height;
			findDepth(node.getLeftChild(), depthCount);
			findDepth(node.getRightChild(), depthCount);
		}
	}
	
	protected void enqueueChildren(CircularQueue queue, TreeNode<T> theNode) {
		TreeNode<T> childNode = theNode.getLeftChild();
		if (childNode != null) {
			queue.enqueue(childNode);
		}
		
		childNode = theNode.getRightChild();
		if (childNode != null) {
			queue.enqueue(childNode);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected boolean comparison(Object theNode, T theValue) {
		TreeNode<T> node = (TreeNode<T>) theNode;
		Comparable comparable = (Comparable) node.getData();

		if (comparable.compareTo(theValue) == 0) {
			return true;
		} else {
			return false;
		}
	}
}
