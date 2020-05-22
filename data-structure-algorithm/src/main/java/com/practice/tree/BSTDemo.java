package com.practice.tree;
import java.util.Scanner;

public class BSTDemo {

	public static void main(String[] args) {
		BST bst = new BST();

		bst.insert(25);
		bst.insert(40);
		bst.insert(50);
		bst.insert(38);
		bst.insert(60);
		bst.insert(10);
		bst.traverse();
		System.out.println("\nHeight of the Tree:                                   " + bst.height());
		System.out.println("Size of the Tree(40):                                 " + bst.size(40));
		System.out.println("Height of the node(40) in the Tree:                   " + bst.height(40));
		System.out.println("Height difference of the left and right subtree(50):  " + bst.heightBalance(50));
		System.out.println("Remove 20: " + bst.delete(20));
		System.out.println("Remove 38: " + bst.delete(38));
		System.out.println("Size of the Tree:                                     " + bst.size());
		bst.traverse();
		System.out.println("\nHeight of the Tree: " + bst.height());
	}
	
	public static class BST {
		Node root;

		public void insert(int theValue) {
			if(null == root) {
				root = new Node(theValue, null);
			}
			else {
				insertInBST(this.root, theValue);
			}
		}
		
		public boolean search(int theValue) {
			if(null == this.root) {
				return false;
			}
			else {
				return (searchInBST(this.root, theValue) == null) ? false : true;
			}
		}
		
		public boolean delete(int theValue) {
			Node nodeToBeDeleted = searchInBST(this.root, theValue);
			return deleteFromTree(nodeToBeDeleted);
		}
		
		public void traverse() {
			inOrderTraversal(this.root) ;
		}
		
		public int height() {
			return heightOfNode(this.root);
		}
		
		public int height(int theValue) {
			Node nodeOfSubject = searchInBST(this.root, theValue);
			return heightOfNode(nodeOfSubject);
		}
		
		public int heightBalance() {
			return heightDiffAt(this.root);
		}
		
		public int heightBalance(int theValue) {
			Node nodeOfSubject = searchInBST(this.root, theValue);
			return heightDiffAt(nodeOfSubject);
		}
		
		public int size() {
			return nodeCount(this.root, 0);
		}
		
		public int size(int theValue) {
			Node nodeOfSubject = searchInBST(this.root, theValue);
			return nodeCount(nodeOfSubject, 0);
		}
		
		private int nodeCount(Node theNode, int count) {
			if(theNode == null) {
				return count;
			}
			else {
				count = nodeCount(theNode.getLeft(), count);
				count++;
				count = nodeCount(theNode.getRight(), count);
			}
			return count;
		}
		
		private  int heightDiffAt(Node theNode) {
			int leftSubtreeHeight = heightOfNode(theNode.getLeft());
			int rightSubtreeHeight = heightOfNode(theNode.getRight());
			if(leftSubtreeHeight > rightSubtreeHeight) {
				return leftSubtreeHeight - rightSubtreeHeight;
			}
			else {
				return rightSubtreeHeight - leftSubtreeHeight;
			}
		}
		
		private void insertInBST(Node theNode, int theValue) {
			Node currentNode;
			if(theValue <= theNode.getValue()) {
				if((currentNode = theNode.getLeft()) == null) {
					theNode.setLeft(new Node(theValue, theNode));
					return;
				}
			}
			else {
				if((currentNode = theNode.getRight()) == null) {
					theNode.setRight(new Node(theValue, theNode));
					return;
				}
			}
			
			insertInBST(currentNode, theValue);
		}
		
		private Node searchInBST(Node theNode, int theValue) {
			if(theNode == null) {
				return null;
			}
			
			int nodeValue = theNode.getValue();
			if(theValue == nodeValue) {
				return theNode;
			}
			
			Node currentNode = null;
			if(theValue < nodeValue) {
				currentNode = theNode.getLeft();
			}
			else {
				currentNode = theNode.getRight();
			}
			
			return searchInBST(currentNode, theValue);
		}
		
		private Node searchInBST_v1(Node theNode, Node parent, int theValue, boolean found) {
			if(theNode == null) {
				if(found)
					return parent;
				else
					return null;
			}
			
			int nodeValue = theNode.getValue();
			if(found &&(theValue != nodeValue)) {
				return parent;
			}
			if(theValue == nodeValue) {
				found = true;
			}
			
			Node currentNode = null;
			if(theValue <= nodeValue) {
				currentNode = theNode.getLeft();
			}
			else {
				currentNode = theNode.getRight();
			}
			
			return searchInBST_v1(currentNode, theNode, theValue, found);
		}
		
		private boolean deleteFromTree(Node nodeToBeDeleted) {
			if(null == nodeToBeDeleted) {
				return false;
			}
			if((nodeToBeDeleted.getLeft() != null) && (nodeToBeDeleted.getRight() != null)) {
				Node successor = nodeToBeDeleted.getRight();
				while(successor.getLeft() != null) {
					successor = successor.getLeft();
				}
				nodeToBeDeleted.setValue(successor.getValue());
				deleteNode(successor, successor.getRight());
			}
			else {
				Node child = null;
				if((child = nodeToBeDeleted.getLeft()) == null) {
					child = nodeToBeDeleted.getRight();
				}
				deleteNode(nodeToBeDeleted, child);
			}
			return true;
		}
		
		private void deleteNode(Node node, Node child) {
			Node parent = node.getParent();
			if(parent.getLeft().getValue() == node.getValue()) {
				parent.setLeft(child);
			}
			else {
				parent.setRight(child);
			}
		}
		
		private void inOrderTraversal(Node theNode) {
			if(theNode != null) {
				inOrderTraversal(theNode.getLeft());
				System.out.print(theNode.getValue() + " ");
				inOrderTraversal(theNode.getRight());
			}
		}
		
		private int minCount(Node theNode, int theValue, int count) {
			if(theNode != null) {
				count = minCount(theNode.getLeft(), theValue, count);
				//System.out.print(theNode.getValue() + " ");
				if(theNode.getValue() < theValue)
					count++;
				count = minCount(theNode.getRight(), theValue, count);
			}
			return count;
		}
		
		private int heightOfNode(Node theNode) {
			if(null == theNode) {
				return 0;
			}
			int leftHeight = heightOfNode(theNode.getLeft());
			int rightHeight = heightOfNode(theNode.getRight());
			if(leftHeight > rightHeight) {
				return leftHeight + 1;
			}
			else {
				return rightHeight + 1;
			}
		}
	}
	
	public static class Node {
		int value;
		Node left;
		Node right;
		Node parent;
		
		public Node(int theValue, Node theParent) {
			this.value = theValue;
			this.parent = theParent;
		}
		
		public void setValue(int theValue) {
			this.value = theValue;
		}
		
		public int getValue() {
			return this.value;
		}
		
		public void setLeft(Node theLeft) {
			this.left = theLeft;
		}
		
		public Node getLeft() {
			return this.left;
		}
		
		public void setRight(Node theRight) {
			this.right = theRight;
		}
		
		public Node getRight() {
			return this.right;
		}
		
		public Node getParent() {
			return this.parent;
		}
	}
	
	public static void takeInput(BST bst) {
		String[] responses;
		Scanner scanner = new Scanner(System.in);
		int noTestCases = Integer.parseInt(scanner.nextLine());
		for(int i=0; i < noTestCases; i++) {
			int studentsInside = scanner.nextInt();
			System.out.print(" ");
			int studentsOutside = Integer.parseInt(scanner.next());
			responses = new String[studentsOutside];
			System.out.println();
			int candies;
			for(int j=0; j < studentsInside; j++) {
				candies = Integer.parseInt(scanner.next());
				System.out.print(" ");
				bst.insert(candies);
			}
			for(int k=0; k < studentsOutside; k++) {
				candies = Integer.parseInt(scanner.next());
				System.out.print(" ");
				responses[k] = bst.search(candies) ? "YES" : "NO";
				bst.insert(candies);
			}
			for(String response:responses) {
				System.out.println(response);
			}
		}
		
		scanner.close();
	}

}
