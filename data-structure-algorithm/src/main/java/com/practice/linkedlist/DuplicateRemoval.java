package com.practice.linkedlist;
/*
Leetcode#83. Remove Duplicates from Sorted List
Given a sorted linked list, delete all duplicates such that each element appear only once.
*/
public class DuplicateRemoval {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode previous = head;
		ListNode after;
		while (previous != null && previous.next != null) {
			after = previous.next;
			while (after != null && previous.val == after.val) {
				after = after.next;
			}
			previous.next = after;
			previous = after;
		}

		return head;
	}

}
