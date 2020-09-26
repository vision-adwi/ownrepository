package com.practice.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
	
	/*
	Leetcode#1019. Next Greater Node In Linked List
	We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.

	Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, 
	and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.
	Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).

	Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list 
	with a head node value of 2, second node value of 1, and third node value of 5.
	*/
	public int[] nextLargerNodes(ListNode head) {
		List<Integer> list = new ArrayList<>();
		LinkedList<Integer> stack = new LinkedList<>();
		
		while(head != null) {
			list.add(head.val);
			head = head.next;
		}
		
		int[] result = new int[list.size()];
		for(int i = list.size() - 1; i >= 0; i--) {
			while(!stack.isEmpty() && list.get(i) >= stack.peek())
				stack.poll();
			
			if(stack.isEmpty())
				result[i] = 0;
			else
				result[i] = stack.peek();
			
			stack.push(list.get(i));
		}
		
		return result;
	}
	
	public ListNode removeFromCircularList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				if(fast == head) {
					head = head.next;
					fast.next = null;
					break;
				}
				fast = head;
				ListNode previous = null;
				while(slow != fast) {
					previous = slow;
					fast = fast.next;
					slow = slow.next;
				}
				previous.next = null;
				break;
			}
		}
		
		return head;
	}

}
