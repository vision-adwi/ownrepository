package com.practice.linkedlist;
/*
Leetcode#234. Palindrome Linked List
Given a singly linked list, determine if it is a palindrome.
*/
public class PalindromeList {
	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null)
			return true;
		
		ListNode middle = middleNode(head);
		ListNode reverseNode = reverse(middle);
		while(head != middle) {
			if(head.val != reverseNode.val)
				return false;
			
			head = head.next;
			reverseNode = reverseNode.next;	
		}
		
        return true;
    }
	
	private ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	private ListNode reverse(ListNode middle) {
		ListNode current = null;
		ListNode nextNode = middle;
		ListNode tmp = null;
		while(nextNode != null) {
			tmp = nextNode.next;
			nextNode.next = current;
			current = nextNode;
			nextNode = tmp;
		}
		
		return current;
	}

}
