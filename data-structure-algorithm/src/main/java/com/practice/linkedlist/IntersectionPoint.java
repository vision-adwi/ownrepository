package com.practice.linkedlist;
/*
Leetcode#160. Intersection of Two Linked Lists
Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:
*/	
public class IntersectionPoint {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int sizeA = size(headA);
		int sizeB = size(headB);
		int diff = 0;
		if(sizeA > sizeB) {
			diff = sizeA - sizeB;
			for(int i = 0; i < diff; i++)
				headA = headA.next;
		}
		else if(sizeB > sizeA) {
			diff = sizeB - sizeA;
			for(int i = 0; i < diff; i++)
				headB = headB.next;
		}
		
		while(headA != null && headB != null) {
			if(headA == headB)
				break;
			
			headA = headA.next;
			headB = headB.next;
		}
		
		
        return headA;
    }
	
	private int size(ListNode node) {
		ListNode current = node;
		int size = 0;
		while(current != null) {
			current = current.next;
			size++;
		}
		return size;
	}

}
