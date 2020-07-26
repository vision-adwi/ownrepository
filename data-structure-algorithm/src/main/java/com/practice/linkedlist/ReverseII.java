package com.practice.linkedlist;
/*
Leetcode#92. Reverse Linked List II
Reverse a linked list from position m to n. Do it in one-pass.
*/
public class ReverseII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode preBegin = null;
		ListNode begin = head;
		int length = n - m;
		while(--m > 0) {
			preBegin = begin;
			begin = begin.next;
		}

		ListNode previous = null;
		ListNode current = begin;
		while(length-- >= 0) {
			ListNode tmp = current.next;
			current.next = previous;
			previous = current;
			current = tmp;
		}
		
		begin.next = current;
		if(preBegin == null) {
			head = previous;
		}
		else {
			preBegin.next = previous;
		}
        
		return head;
    }
	
	public static void main(String[] s) {
		ReverseII reverse = new ReverseII();
	}

}
