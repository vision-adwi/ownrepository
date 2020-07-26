package com.practice.linkedlist;
/*
Leetcode#445. Add Two Numbers II
You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/
public class Add2NumbersII {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l1_reverse = reverse(l1);
		ListNode l2_reverse = reverse(l2);
		
		ListNode result = null, current = null;
		int carry = 0;
		while(l1_reverse != null || l2_reverse != null) {
			int val1 = 0, val2 = 0;
			if(l1_reverse != null) {
				val1 = l1_reverse.val;
				l1_reverse = l1_reverse.next;
			}
			if(l2_reverse != null) {
				val2 = l2_reverse.val;
				l2_reverse = l2_reverse.next;
			}
			
			ListNode result_node = new ListNode((val1 + val2 + carry) % 10);
			if(current == null) {
				result = current = result_node;
			}
			else {
				current.next = result_node;
				current = result_node;
			}
			
			carry = (val1 + val2 + carry) / 10;
		}
		if(carry > 0)
			current.next = new ListNode(carry);
        
		return reverse(result);
    }
	
	private ListNode reverse(ListNode head) {
		ListNode previous = null;
		ListNode current = head;
		
		ListNode tmp = null;
		while(current != null) {
			tmp = current.next;
			current.next = previous;
			previous = current;
			current = tmp;
		}
		head = previous;
		
		return head;
	}
	
	public static void main(String[] s) {
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		
		Add2NumbersII add = new Add2NumbersII();
		add.addTwoNumbers(l1, l2);
	}

}
