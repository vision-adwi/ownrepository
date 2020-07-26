package com.practice.linkedlist;
/*
Leetcode#24. Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes, only nodes itself may be changed.
*/
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
    	ListNode tmp = head;
    	ListNode prev = null;
    	ListNode curr = null;
    	
    	while(tmp != null && tmp.next != null) {
    		prev = tmp;
    		curr = prev.next;
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
}
