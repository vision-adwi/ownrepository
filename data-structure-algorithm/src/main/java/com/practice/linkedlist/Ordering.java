package com.practice.linkedlist;

import com.practice.util.ListNode;

public class Ordering {
	/*
	Leetcode#143. Reorder List
	*/
    public void reorderList(ListNode head) {
    	if(head == null || head.next == null)
            return;
    	
    	ListNode slow = head;
    	ListNode fast = head;
    	while(fast != null && fast.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}

    	ListNode setOne = head;
    	ListNode setTwo = Reverses.reverseList(slow);

    	ListNode current = setOne;
    	while(setOne != null && setTwo != null) {
    		setOne = (setOne.next == slow) ? null : setOne.next;
    		current.next = setTwo;   		
    		current = current.next;
    		 
    		setTwo = setTwo.next; 	
    		current.next = (setOne == null) ? setTwo : setOne;
    		current = current.next;
    	}  
    }
    
    /*
    Leetcode#86. Partition List
    Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
    You should preserve the original relative order of the nodes in each of the two partitions.

    Input: head = 1->4->3->2->5->2, x = 3
    Output: 1->2->2->4->3->5
    */
	public ListNode partition(ListNode head, int x) {
		ListNode preHead = new ListNode(0);
		ListNode pivot = new ListNode(0);

		ListNode smaller = preHead;
		ListNode larger = pivot;

		ListNode current = head;
		while (current != null) {
			if (current.val < x) {
				smaller.next = current;
				smaller = smaller.next;
			} else {
				larger.next = current;
				larger = larger.next;
			}

			current = current.next;
		}
		smaller.next = pivot.next;
		larger.next = null;

		return preHead.next;
	}

	/*
	Leetcode#61. Rotate List
	*/
    public ListNode rotateRight(ListNode head, int k) {
    	ListNode preHead = new ListNode(0);
    	preHead.next = head;
    	
    	ListNode pred = preHead;
    	ListNode current = preHead;
    	for(int i = 0; i <= k; i++) {
    		current = current.next;
    		if(current == null) {
    			k = k % i;
    			i = 0;
    			current = preHead.next;
    		}
    	}
    	
    	if(current == preHead.next)
            return current;
    	
    	while(current != null) {
    		current = current.next;
    		pred = pred.next;
    	}
    	
    	ListNode tmp = preHead.next;
    	preHead.next = pred.next;
    	pred.next = null;
    	
    	current = preHead.next;
    	while(current.next != null) {
    		current = current.next;
    	}
    	current.next = tmp;
        
    	return preHead.next;
    }
	
    /*
    Leetcode#147. Insertion Sort List
    Sort a linked list using insertion sort.
    */
	public ListNode insertionSortList(ListNode head) {
		ListNode preHead = new ListNode(0);

		ListNode tmp;
		while (head != null) {
			ListNode previous = preHead;
			ListNode current = previous.next;

			while (current != null && current.val <= head.val) {
				previous = current;
				current = previous.next;
			}
			previous.next = head;
			tmp = head.next;
			head.next = current;

			head = tmp;
		}

		return preHead.next;
	}
	
	/*
	Leetcode#328. Odd Even Linked List
	Given a singly linked list, group all odd nodes together followed by the even nodes. 
	Please note here we are talking about the node number and not the value in the nodes.

	You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
	*/
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null || head.next.next == null)
			return head;
		
		ListNode odd = head;
		ListNode even = odd.next;
		ListNode evenHead = even;
		
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;

			even.next = odd.next;
			even = even.next;
		}
		
		odd.next = evenHead;
		return head;
	}
}
