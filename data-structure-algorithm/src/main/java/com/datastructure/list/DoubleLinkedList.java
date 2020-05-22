package com.datastructure.list;


public class DoubleLinkedList {
	private NodeDLL head = null;
	private NodeDLL tail = null;
	
	public DoubleLinkedList(String nodeValue) {
		NodeDLL theNode = new NodeDLL(nodeValue);
		
		head = theNode;
		tail = theNode;
	}
	
	public void insertAtHead(NodeDLL theNode) {
		theNode.nextNode = head;
		head.previousNode = theNode;
		
		head = theNode;
	}
	
	public void insertAtEnd(NodeDLL theNode) {
		tail.nextNode = theNode;
		theNode.previousNode = tail;
		
		tail = theNode;
	}
	
	public void insert(String nodeValue, int location) {
		// Check if linked list is not empty
		if (head == null) {
			return;
		}

		//Insert at Head position
		NodeDLL theNode = new NodeDLL(nodeValue);
		if (location == 0) {
			System.out.println("Insert At head.");
			insertAtHead(theNode);
			return;
		}

		NodeDLL tempNode = head;
		for (int i = 0; i < location-1 && tempNode != null; i++) {
			tempNode = tempNode.nextNode;
		}
		
		//Insert at end position
		if (tempNode == tail || tempNode == null) {
			System.out.println("Insert at tail.");
			insertAtEnd(theNode);
			return;
		}
		
		System.out.println("Insert in the middle");
		theNode.nextNode = tempNode.nextNode;
		theNode.previousNode = tempNode;
		
		tempNode.nextNode.previousNode = theNode;
		tempNode.nextNode = theNode;
	}
	
	//Traversal - O(n)
	public void traverse() {
		// Check if Linked list is not empty
		System.out.println("Head:" + head.nodeValue + " Tail:" + tail.nodeValue);
		if (head == null) {
			return;
		}

		int position = 0;
		NodeDLL tempNode = head;
		while (true) {
			System.out.println(position++ + " " + tempNode.nodeValue);
			if (tempNode == tail) {
				return;
			} else {
				tempNode = tempNode.nextNode;
			}
		}
	}
	
	//Traversal - O(n)
	public void traverseBackward() {
		// Check if Linked list is not empty
		if (head == null) {
			return;
		}

		int position = 0;
		NodeDLL tempNode = tail;
		while (true) {
			System.out.println(position++ + " from tail : " + tempNode.nodeValue);
			if (tempNode == head) {
				return;
			} else {
				tempNode = tempNode.previousNode;
			}
		}
	}
	
	//Search - O(n)
	public int search(String theNodeValue) {
		// Check if Linked list is not empty
		if (head == null) {
			return Integer.MIN_VALUE;
		}

		int position = 0;
		NodeDLL tempNode = head;
		while (true) {
			if (tempNode.nodeValue == theNodeValue) {
				return position;
			}
			if (tempNode == tail) {
				return Integer.MIN_VALUE;
			} else {
				tempNode = tempNode.nextNode;
				position++;
			}
		}
	}
	
	public void delete(int location) {
		//Check if linked list is empty
		if (head == null) {
			return;
		}
		
		//Delete the only node in the linked list
		if (head == tail) {
			head = null;
			tail = null;
			return;
		}
		
		// Delete from Head position
		if (location == 0) {
			System.out.println("Deleting from head.");
			head = head.nextNode;

			head.previousNode.nextNode = null;  //This step can be eliminated
			head.previousNode = null;
			
			return;
		}

		NodeDLL tempNode = head;
		for (int i = 0; i < location - 1 && tempNode.nextNode.nextNode != null; i++) {
			tempNode = tempNode.nextNode;
		}

		// Deleting last node
		if (tempNode.nextNode == tail) {
			System.out.println("Deleting from tail.");
			tail.previousNode = null;  //This step can be eliminated
			tempNode.nextNode = null;

			tail = tempNode;
			return;
		}
		
		// Delete the node in the middle
		System.out.println("Deleting from middle.");
		tempNode.nextNode.previousNode = null;				//This step can be eliminated
		tempNode.nextNode = tempNode.nextNode.nextNode;
		tempNode.nextNode.previousNode.nextNode = null;		//This step can be eliminated
		tempNode.nextNode.previousNode = tempNode;

	}
	
	public void kill() {
		if(head==null) {
			return;
		}
		
		NodeDLL tempNode = head;
		while (tempNode.nextNode != null) {
			tempNode.previousNode = null;
			tempNode = tempNode.nextNode;
		}
		
		head = null;
		tail = null;
		
	}

}
