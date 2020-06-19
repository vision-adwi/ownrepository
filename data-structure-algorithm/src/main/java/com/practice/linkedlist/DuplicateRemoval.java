package com.practice.linkedlist;

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
