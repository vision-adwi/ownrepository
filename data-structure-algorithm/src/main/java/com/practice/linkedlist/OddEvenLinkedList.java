package com.practice.linkedlist;

import com.practice.util.ListNode;

/*
Leetcode#328. Odd Even Linked List
Given a singly linked list, group all odd nodes together followed by the even nodes. 
Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
*/
public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null || head.next.next == null)
			return head;
		
		ListNode oddNode = head;
		ListNode evenNode = head.next;
		
		ListNode currentOddNode = oddNode;
		ListNode currentEvenNode = evenNode;
		while(currentOddNode != null && currentOddNode.next != null) {
			currentOddNode.next = currentOddNode.next.next;
			currentOddNode = currentOddNode.next;
			
			if(currentOddNode == null) {
				currentEvenNode.next = null;
			}
			else {
				currentEvenNode.next = currentOddNode.next;
			}
			currentEvenNode = currentEvenNode.next;
		}
		
		currentOddNode = oddNode;
		while(currentOddNode.next != null)
			currentOddNode = currentOddNode.next;
		
		currentOddNode.next = evenNode;
		
		return oddNode;  
    }

}
