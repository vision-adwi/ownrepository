package com.practice.linkedlist;
/*
Leetcode#1290. Convert Binary Number in a Linked List to Integer
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. 
The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.
*/
public class BinToInt {
	public int getDecimalValue(ListNode head) {
		ListNode reverseList = reverse(head);
		
		int radix = 0;
		int result = reverseList.val;
		ListNode nextNode = reverseList.next;
		while(nextNode != null) {
			result += nextNode.val << ++radix;
			nextNode = nextNode.next;
		}
		
		return result;
    }
	
	private ListNode reverse(ListNode head) {
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
