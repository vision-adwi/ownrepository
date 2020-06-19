package com.practice.linkedlist;
/*
Leetcode#206. Reverse Linked List
Reverse a singly linked list.
*/
public class Reverse {
	public ListNode reverseList(ListNode head) {
		if (head != null) {
			ListNode current = null;
			ListNode nextNode = head;

			ListNode tmp;
			while (nextNode != null) {
				tmp = nextNode.next;
				nextNode.next = current;
				current = nextNode;
				nextNode = tmp;
			}
			head = current;
		}
		
		return head;
	}
	


}
