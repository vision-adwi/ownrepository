package com.practice.linkedlist;

import com.practice.util.ListNode;

/*
Leetcode#147. Insertion Sort List
Sort a linked list using insertion sort.
*/
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		ListNode preSortedHead = new ListNode(0);

		while (head != null) {
			ListNode tmp = head.next;
			head.next = null;

			ListNode predecessor = preSortedHead;
			ListNode successor = predecessor.next;

			while (successor != null && head.val < successor.val) {
				predecessor = successor;
				successor = successor.next;
			}
			predecessor.next = head;
			head.next = successor;

			head = tmp;
		}

		return Reverses.reverseList(preSortedHead.next);
	}
}
