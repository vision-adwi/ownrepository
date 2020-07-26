package com.practice.linkedlist;
/*
Leetcode# 876. Middle of the Linked List
Given a non-empty, singly linked list with head node head, return a middle node of linked list.
If there are two middle nodes, return the second middle node.
*/		
public class MiddleOfList {
	public ListNode middleNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		if (head != null) {
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
		}

		return slow;
	}
}
