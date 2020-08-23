package com.practice.linkedlist;

import com.practice.util.ListNode;

public class LLUtils {
	/*
	Leetcode# 876. Middle of the Linked List
	Given a non-empty, singly linked list with head node head, return a middle node of linked list.
	If there are two middle nodes, return the second middle node.
	*/
	public ListNode middleNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}
	
	/*
	Leetcode #141. Linked List Cycle
	Given a linked list, determine if it has a cycle in it.
	To represent a cycle in the given linked list, we use an integer pos which represents 
	the position (0-indexed) in the linked list where tail connects to. If pos is -1, then 
	there is no cycle in the linked list.
	*/
	public boolean hasCycle(ListNode head) {
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
	
	/*
	Leetcode#142. Linked List Cycle II
	Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
	To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) 
	in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
	*/
	public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow) {
                fast = head;
                while(fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        
        return null;
    }
	
	/*
	Leetcode#234. Palindrome Linked List
	Given a singly linked list, determine if it is a palindrome.
	*/
	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null)
			return true;
		
		ListNode middle = middleNode(head);
		ListNode reverseNode = Reverses.reverseList(middle);
		while(head != middle) {
			if(head.val != reverseNode.val)
				return false;
			
			head = head.next;
			reverseNode = reverseNode.next;	
		}
		
        return true;
    }
	
	/*
	Leetcode#1290. Convert Binary Number in a Linked List to Integer
	Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. 
	The linked list holds the binary representation of a number.

	Return the decimal value of the number in the linked list.
	*/
	public int getDecimalValue(ListNode head) {
		head = Reverses.reverseList(head);
		
		int result = 0;
		int radix = 0;
		while(head != null) {
			result = result + (head.val << radix++);
			head = head.next;
		}
		
		return result;
	}

}
