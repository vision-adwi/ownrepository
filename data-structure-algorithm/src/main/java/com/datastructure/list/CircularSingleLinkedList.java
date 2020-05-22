package com.datastructure.list;


public class CircularSingleLinkedList {
	private NodeLL head = null;
	private NodeLL tail = null;
	
	public CircularSingleLinkedList(String theCoachNumber) {
		NodeLL theNode = new NodeLL();
		theNode.coachNumber = theCoachNumber;
		theNode.nextNode = theNode; //
		
		head = theNode;
		tail = theNode;
	}
	
	public void insert(String theCoachNumber, int position) {
		// Check if Linked list is not empty
		if (head == null) {
			return;
		}
		NodeLL theNode = new NodeLL();
		theNode.coachNumber = theCoachNumber;

		// Insert at the head - O(1)
		if (position == 0) {
			insertAtHead(theNode);
			return;
		}

		NodeLL tempNode = head;
		for (int i = 0; i < position - 1 && head != tempNode.nextNode; i++) {
			tempNode = tempNode.nextNode;
		}
		// Insert at the end
		if (tempNode.nextNode == head) {
			insertAtEnd(theNode);
			return;
		}

		// Insert in middle
		System.out.println("Insertion at middle position.");
		theNode.nextNode = tempNode.nextNode;
		tempNode.nextNode = theNode;
	}
	
	//Traversal - O(n)
	public void traverse() {
		// Check if Linked list is not empty
		if (head == null) {
			return;
		}

		int position = 0;
		NodeLL tempNode = head;
		while (true) {
			System.out.println(position++ + " " + tempNode.coachNumber);
			if (tempNode == tail) {
				return;
			} else {
				tempNode = tempNode.nextNode;
			}
		}
	}
	
	//Search - O(n)
	public int search(String theCoachNumber) {
		// Check if Linked list is not empty
		if (head == null) {
			return Integer.MIN_VALUE;
		}

		int position = 0;
		NodeLL tempNode = head;
		while (true) {
			if (tempNode.coachNumber == theCoachNumber) {
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
	
	public void delete(int position) {
		// Check if linked-list exist
		if (head == null) {
			return;
		}
		// Delete at the head - O(1)
		if (position == 0) {
			// When there is only one node in the linked-list
			if (head == tail) {
				System.out.println("Deleting from head(last item)");
				head.nextNode = null; //Important
				head = null;
				tail = null;
			} else {
				System.out.println("Deleting from head");
				head = head.nextNode;
				tail.nextNode = head;
			}

			return;
		}

		NodeLL tempNode = head;
		for (int i = 0; i < position - 1 && tempNode.nextNode != head; i++) {
			tempNode = tempNode.nextNode;
		}
		if (tempNode.nextNode != head) {
			tempNode.nextNode = tempNode.nextNode.nextNode;
			// If node to be deleted is the end node
			if (tempNode.nextNode == head) {
				System.out.println("Deleting from tail");
				tail = tempNode;
			}
			else {
				System.out.println("Deleting from middle");
			}
		}
	}
	
	public void kill() {
		head = null;
		tail.nextNode = null;
		tail = null;
	}
	
	public void insertAtHead(NodeLL theNode) {
		System.out.println("Insertion at Head position.");
		theNode.nextNode = head;
		head = theNode;
		tail.nextNode = head; //Different from SLL
	}
	
	public void insertAtEnd(NodeLL theNode) {
		System.out.println("Insertion at Tail position.");
		theNode.nextNode = head; //Different from SLL
		
		tail.nextNode = theNode;
		tail = theNode;
	}

}
