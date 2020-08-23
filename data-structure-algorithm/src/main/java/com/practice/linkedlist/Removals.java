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
		while (head != null && head.val == val) {
			head = head.next;
		}

		ListNode current = head;
		ListNode successor;
		while (current != null) {
			successor = current;
			while (successor.next != null && successor.next.val == val) {
				successor = successor.next;
			}

			current.next = successor.next;
			current = current.next;
		}

		return head;
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
		
		for(int i = 1; i <= n + 1; i++) {
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
		ListNode predecessor = head;
		ListNode successor;
		while (predecessor != null && predecessor.next != null) {
			successor = predecessor.next;
			while (successor != null && predecessor.val == successor.val) {
				successor = successor.next;
			}
			predecessor.next = successor;
			predecessor = successor;
		}

		return head;
	}
	
	/*
	Leetcode#82. Remove Duplicates from Sorted List
	Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

	Return the linked list sorted as well.
	*/
	public ListNode deleteDuplicates2(ListNode head) {
		ListNode preHead = new ListNode(0);

		ListNode pred = preHead;
		ListNode current = head;
		while(current != null) {
			boolean unique = true;
			while(current.next != null && current.val == current.next.val) {
				current = current.next; 
				unique = false;
			}
			
			if(unique) {
				pred.next = current;
				pred = pred.next;
			}

			current = current.next;
			pred.next = null;
		}

		return preHead.next;
	}
}
