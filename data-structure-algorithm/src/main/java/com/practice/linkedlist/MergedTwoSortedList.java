package com.practice.linkedlist;

public class MergedTwoSortedList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode resultant = null;
		
		if(l1 == null) 
			return l2;
		
		if(l2 == null)
			return l1;
		
		if(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				resultant = l1;
				l1 = l1.next;
			}
			else {
				resultant = l2;
				l2 = l2.next;
			}
		}
		
		ListNode tmp = resultant;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tmp.next = l1;
				l1 = l1.next;
			} else {
				tmp.next = l2;
				l2 = l2.next;
			}
			tmp = tmp.next;
		}
		
		if(l1 != null)
			tmp.next = l1;
		
		if(l2 != null)
			tmp.next = l2;

		return resultant;
    }
}


class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

/*class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
    }
}*/
