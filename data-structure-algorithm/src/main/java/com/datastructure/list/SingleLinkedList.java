package com.datastructure.list;


public class SingleLinkedList implements List{
	private NodeLL head = null;
	private NodeLL tail = null;
	
	public SingleLinkedList() {
	}

	private void insertAtEnd(NodeLL theNode) {
		if (head == null) {//Empty
			head = theNode;
		} else {
			tail.nextNode = theNode;
		}
		tail = theNode;
	}
	
	// Insert at the tail - O(1)
	@Override
	public void insert(String theCoachNumber) {
		NodeLL theNode = new NodeLL();
		theNode.coachNumber = theCoachNumber;
		
		insertAtEnd(theNode);
	}
	
	@Override
	public void insert(String theCoachNumber, int position) {
		NodeLL theNode = new NodeLL();
		theNode.coachNumber = theCoachNumber;

		// Insert at the head - O(1)
		if (position == 0) {
			theNode.nextNode = head;
			if (head == null) {// Empty
				tail = theNode;
			}
			head = theNode;
			return;
		}
		
		NodeLL tempNode = head;
		for (int i = 0; i < position - 1 && tempNode != null; i++) {
			tempNode = tempNode.nextNode;
		}
		if (null != tempNode) {
			// Insert at the end
			if (tempNode.nextNode == null) {
				insertAtEnd(theNode);
				return;
			}

			// Insert in middle
			theNode.nextNode = tempNode.nextNode;
			tempNode.nextNode = theNode;
		}
	}
	
	@Override
	public void delete(int position) {
		// Check if linked-list exist
		if (head == null) {
			return;
		}
		// Delete at the head - O(1)
		if (position == 0) {
			head = head.nextNode;
			// When there is only one node in the linked-list
			if (head == null) {
				tail = null;
			}
			return;
		}

		NodeLL tempNode = head;
		for (int i = 0; i < position - 1 && tempNode.nextNode != null; i++) {
			tempNode = tempNode.nextNode;
		}
		if (tempNode.nextNode != null) {
			tempNode.nextNode = tempNode.nextNode.nextNode;
			// If node to be deleted is the end node
			if (tempNode.nextNode == null) {
				tail = tempNode;
			}
		}
	}
	
	//Traversal - O(n)
	@Override
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
	@Override
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
	
	@Override
	public void kill() {
		head = null;
		tail = null;
	}
	
	@Override
	public boolean exist() {
		return (head == null) && (tail == null);
	}

}
