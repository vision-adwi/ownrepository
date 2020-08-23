package com.practice.linkedlist;

import com.practice.util.ListNode;

public class MultipleLists {
	/*
	Leetcode#21. Merge Two Sorted Lists
	Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
	*/
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode preNode = new ListNode(0);
		ListNode current = preNode;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}
		
		if(l1 != null)
			current.next = l1;
		else if(l2 != null)
			current.next = l2;

		return preNode.next;
    }
	
	/*
	Leetcode#160. Intersection of Two Linked Lists
	Write a program to find the node at which the intersection of two singly linked lists begins.
	*/
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode currA = headA;
		ListNode currB = headB;
		while (currA != null && currB != null) {
			currA = currA.next;
			currB = currB.next;
		}

		while (currA != null) {
			currA = currA.next;
			headA = headA.next;
		}

		while (currB != null) {
			currB = currB.next;
			headB = headB.next;
		}

		while (headA != null && headB != null) {
			if (headA == headB)
				break;

			headA = headA.next;
			headB = headB.next;
		}

		return headA;
	}

	/*
	Leetcode#445. Add Two Numbers II
	You are given two non-empty linked lists representing two non-negative integers. 
	The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	*/
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l1_reverse = Reverses.reverseList(l1);
		ListNode l2_reverse = Reverses.reverseList(l2);
		
		ListNode result = new ListNode(0);
		ListNode current = result;
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
			
			int sum = val1 + val2 + carry;
			current.next = new ListNode(sum % 10);
			current = current.next;

			carry = sum / 10;
		}
		current.next = (carry > 0) ? new ListNode(carry) : null;
        
		return Reverses.reverseList(result.next);
    }
	
	/*
	Leetcode#23. Merge k Sorted Lists
	Given an array of linked-lists lists, each linked list is sorted in ascending order.
	Merge all the linked-lists into one sort linked-list and return it.
	*/		
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode preHead = new ListNode(0);
        
        ListNode current = preHead;
        while(true) {
            boolean allDone = true;
            int minIndex = 0;
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] != null) {
                    if(allDone){
                        allDone = false;
                        minIndex = i;
                        continue;
                    }
                    
                    if(lists[i].val < lists[minIndex].val) {
                        minIndex = i;
                    }
                }
            }
            if(allDone)
                break;
            
            current.next = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
            current = current.next;
        }
        current.next = null;
        
        return preHead.next;
    }
}
