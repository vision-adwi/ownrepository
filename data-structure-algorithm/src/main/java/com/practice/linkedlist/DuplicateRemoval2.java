package com.practice.linkedlist;
/*
Leetcode#82. Remove Duplicates from Sorted List
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Return the linked list sorted as well.
*/
public class DuplicateRemoval2 {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode previous = null;
		ListNode current = head;
		
		boolean flag = true;
		while(current != null) {
			flag = true;
			while(current.next != null && current.val == current.next.val) {
				current = current.next; 
				flag = false;
			}
			
			if(flag) {
				if(previous == null) {
					head = current;
					previous = current;
				}
				else {
					previous.next = current;
					previous = current;
				}
			}

			current = current.next;
		}
		if(previous != null && !flag)
			previous.next = null;
		
		return previous == null ? null : head;
	}
}
