package com.practice.linkedlist;
/*
Leetcode#203. Remove Linked List Elements
Remove all elements from a linked list of integers that have value val.
*/
public class RemoveElements {
	public ListNode removeElements(ListNode head, int val) {
		while (head != null && head.val == val) {
			head = head.next;
		}

		ListNode current = head;
		ListNode after;
		while (current != null) {
			after = current;
			while (after.next != null && after.next.val == val) {
				after = after.next;
			}

			current.next = after.next;
			current = current.next;
		}

		return head;
	}
}
