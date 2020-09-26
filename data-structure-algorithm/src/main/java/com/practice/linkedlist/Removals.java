package com.practice.linkedlist;

import com.practice.util.ListNode;

public class Removals {
	/*
	Leetcode#237. Delete Node in a Linked List
	Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
	*/
	public void deleteNode(ListNode node) {
    	node.val = node.next.val;
    	node.next = node.next.next; 
    }
	
	/*
	Leetcode#203. Remove Linked List Elements
	Remove all elements from a linked list of integers that have value val.
	*/
	public ListNode removeElements(ListNode head, int val) {
		ListNode preHead = new ListNode(0);
		preHead.next = head;

		ListNode previous = preHead;
		ListNode current = previous.next;
		while (true) {
			while (current != null && current.val == val)
				current = current.next;

			previous.next = current;
			if(current == null)
				break;
			
			previous = current;
			current = current.next;
		}

		return preHead.next;
	}
	
	/*
	Leetcode#19. Remove Nth Node From End of List
	Given a linked list, remove the n-th node from the end of list and return its head.
	*/
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode preNode = new ListNode(0); //Just to handle corner cases
		preNode.next = head;
		
		ListNode pointerOne = preNode;
		ListNode pointerTwo = preNode;
		
		for(int i = 0; i <= n; i++) {
			pointerOne = pointerOne.next;
		}
		
		while(pointerOne != null) {
			pointerOne = pointerOne.next;
			pointerTwo = pointerTwo.next;
		}
		
		pointerTwo.next = pointerTwo.next.next;
		
		return preNode.next;
    }
	
	/*
	Leetcode#83. Remove Duplicates from Sorted List
	Given a sorted linked list, delete all duplicates such that each element appear only once.
	*/
	public ListNode deleteDuplicates(ListNode head) {
		ListNode preHead = new ListNode(0);
		preHead.next = head;
		
		ListNode previous = preHead;
		ListNode current = previous.next;
		while(true) {
			while(current != null && current.next != null && current.val == current.next.val)
				current = current.next;
			
			previous.next = current;
			if(current == null)
				break;
			
			previous = current;
			current = previous.next;
		}
		
		return preHead.next;
	}

	/*
	Leetcode#82. Remove Duplicates from Sorted List
	Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

	Return the linked list sorted as well.
	*/
	public ListNode deleteDuplicates2(ListNode head) {
		ListNode preHead = new ListNode(0);
		preHead.next = head;

		ListNode previous = preHead;
		ListNode current = previous.next;
		while(current != null) {
			boolean unique = true;
			while(current.next != null && current.val == current.next.val) {
				current = current.next; 
				unique = false;
			}
			
			if(unique) {
				previous.next = current;
				previous = previous.next;
			}

			current = current.next;
		}
		previous.next = null;

		return preHead.next;
	}
}
