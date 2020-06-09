package com.datastructure.tree.redblack;
import static com.datastructure.tree.redblack.RBNode.BLACK;
import static com.datastructure.tree.redblack.RBNode.RED;

public class RedBlackTree {
	private RBNode root;
	
	public void insert(int newKey) {
		// Case - When root is not created
		if(this.root == null) {
			this.root = new RBNode(null, newKey);
			this.root.setColor(BLACK);
			return;
		}
		
		RBNode newNode = insertInRBT(this.root, newKey);

		RBNode theNode = newNode;
		while (color(parent(theNode)) == RED) {
			if (parent(theNode) == left(parent(parent(theNode)))) {
				RBNode sibling = right(parent(parent(theNode)));
				if(color(sibling) == RED) {
					sibling.setColor(BLACK);
					parent(theNode).setColor(BLACK);
					parent(parent(theNode)).setColor(RED);
					
					theNode = parent(parent(theNode));
				}
				else {
					if(theNode == right(parent(theNode))) {
						theNode = parent(theNode);
						leftRotate(theNode);
					}
				}

			}
			else {
				RBNode sibling = left(parent(parent(theNode)));
				if(color(sibling) == RED) {
					sibling.setColor(BLACK);
					parent(theNode).setColor(BLACK);
					parent(parent(theNode)).setColor(RED);
					
					theNode = parent(parent(theNode));
				}
				else {
					
				}
			}

		}
	}
	
	private RBNode insertInRBT(RBNode current, int newKey) {
		RBNode next = null;
		RBNode newNode = null;
		if (newKey > current.getKey()) {
			if ((next = current.getRight()) == null) {
				newNode = new RBNode(current, newKey);
				current.setRight(newNode);
				return newNode;
			}

		} else {
			if ((next = current.getLeft()) == null) {
				newNode = new RBNode(current, newKey);
				current.setLeft(newNode);
				return newNode;
			}
		}
		
		return insertInRBT(next, newKey);
	}
	
	private void leftRotate(RBNode node) {
		right(node).setParent(parent(node));
		node.setParent(right(node));
		left(right(node)).setParent(node);

		RBNode temp = left(right(node));
		right(node).setLeft(node);
		node.setRight(temp);
		
		if(parent(parent(node)) == null) {
			this.root = parent(node);
		}
	}
	
	private RBNode parent(RBNode node) {
		return (node == null) ? null : node.getParent();
	}
	
	private RBNode left(RBNode node) {
		return (node == null) ? null : node.getLeft();
	}
	
	private RBNode right(RBNode node) {
		return (node == null) ? null : node.getRight();
	}
	
	private boolean color(RBNode node) {
		return (node == null) ? BLACK : node.getColor();
	}

}
