package com.practice.linkedlist;

public class CopyOfDuplicateRemoval {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode first = null;
		ListNode point;
		
		ListNode previous = head;
		ListNode after;
		while (previous != null && previous.next != null) {
			after = previous.next;

			boolean flag = false;
			while (after != null && previous.val == after.val) {
				after = after.next;
				flag = true;
			}
			if(!flag) {
				if(previous == head) {
					previous = after;
					head = previous;
				}
				else {
					previous = after;
				}

			}
			
			
			previous.next = after;
			previous = after;
		}

		return head;
	}

}
