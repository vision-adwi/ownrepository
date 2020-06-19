package com.practice.linkedlist;
/*
Leetcode #141. Linked List Cycle
Given a linked list, determine if it has a cycle in it.
To represent a cycle in the given linked list, we use an integer pos which represents 
the position (0-indexed) in the linked list where tail connects to. If pos is -1, then 
there is no cycle in the linked list.
*/
public class CycleDetermination {
	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null)
			return false;
		
		if(head == head.next)
			return true;
		
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if(slow == fast)
				return true;
		}
        
		return false;
    }

}
