package com.practice.linkedlist;

import com.practice.util.ListNode;

public class Reverses {
	/*
	Leetcode#206. Reverse Linked List
	Reverse a singly linked list.
	*/
	public static ListNode reverseList(ListNode head) {
		if (head != null) {
			ListNode previous = null;
			ListNode current = head;

			ListNode tmp;
			while (current != null) {
				tmp = current.next;
				current.next = previous;
				previous = current;
				current = tmp;
			}
			head = previous;
		}
		
		return head;
	}
	
	/*
	Leetcode#92. Reverse Linked List II
	Reverse a linked list from position m to n. Do it in one-pass.
	*/
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode preHead = new ListNode(0);
		preHead.next = head;
		
		ListNode predecessor = preHead;
		int length = n - m;
		while(--m > 0) {
			predecessor = predecessor.next;
		}

		ListNode previous = null;
		ListNode current = predecessor.next;
		while(length-- >= 0) {
			ListNode tmp = current.next;
			current.next = previous;
			previous = current;
			current = tmp;
		}
		
		predecessor.next.next = current;
		predecessor.next = previous;

		return preHead.next;
    }
	
	/*
	Leetcode#24. Swap Nodes in Pairs
	Given a linked list, swap every two adjacent nodes and return its head.
	You may not modify the values in the list's nodes, only nodes itself may be changed.
	*/
    public ListNode swapPairs(ListNode head) {
    	ListNode tmp = head;
    	ListNode prev = null;
    	ListNode curr = null;
    	
    	while(tmp != null && tmp.next != null) {
    		prev = tmp;
    		curr = tmp.next;
    		if(head == tmp)
    			head = curr;
    		
    		tmp = curr.next;
    		
    		curr.next = prev;
    		if(tmp != null && tmp.next != null)
    			prev.next = tmp.next;
    		else
    			prev.next = tmp;
    	}
    	
    	return head;  
    }
    
    /*
    Leetcode#25. Reverse Nodes in k-Group
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
    k is a positive integer and is less than or equal to the length of the linked list. If the number 
    of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
    */
    public ListNode reverseKGroup(ListNode head, int k) {
    	ListNode preHead = new ListNode(0);
    	preHead.next = head;
    	
    	ListNode segment = preHead;
    	ListNode segmentHead = preHead.next;
    	while(segmentHead != null) {
    		int count = k;
    		
    		ListNode tmp;
    		ListNode previous = null;
    		ListNode current = segmentHead;
    		while(current != null && count-- > 0) {
    			tmp = current.next;
    			current.next = previous;
    			previous = current;
    			current = tmp;
    		}
    		
    		if(count > 0) {
    			//reverseback
    			current = previous;
    			previous = null;
    			while(current != null) {
        			tmp = current.next;
        			current.next = previous;
        			previous = current;
        			current = tmp;
        		}	
    		}
    		
    		segment.next = previous;
    		segment = segmentHead;
    		
    		segmentHead = current;
    	}
    	   	
        return preHead.next;
    }

}
