package com.practice.linkedlist;
/*
Leetcode#1019. Next Greater Node In Linked List
We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.

Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, 
and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.
Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).

Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list 
with a head node value of 2, second node value of 1, and third node value of 5.
*/
public class NextGreaterNode {
/*	public int[] nextLargerNodes(ListNode head) {
        int result[] = new int[size(head)];
        int resultIndex = 0;
        
        int value; int count; int nextLarger;
        ListNode backtrack;
        while(head != null) {
        	value = head.val;
        	count = 0;
        	nextLarger = -1;
        	backtrack = head;
        	while(head != null) {
        		head = head.next;
        		count++;
        		if(head != null && head.val > value) {
        			nextLarger = head.val;
        			break;
        		}
        	}
        	if(nextLarger == -1) {
        		head = backtrack.next;
        		result[resultIndex++] = 0;
        	}
        	else {
        		for(int i = 0; i < count; i++) {
        			result[resultIndex++] = nextLarger;
        		}
        	}
        }
        
        return result;
    }*/
	
	public int[] nextLargerNodes(ListNode head) {
        int result[] = new int[size(head)];
        int resultIndex = 0;
        
        int value; int nextLarger;
        ListNode nextNode;
        while(head != null) {
        	value = head.val;
        	nextLarger = -1;
        	nextNode = head;
        	while(head != null) {
        		head = head.next;
        		if(head != null && head.val > value) {
        			nextLarger = head.val;
        			break;
        		}
        	}
			if (nextLarger == -1) {
				result[resultIndex++] = 0;
			} else {
				result[resultIndex++] = nextLarger;
			}
			head = nextNode.next;
        }
        
        return result;
    }
	
	private int size(ListNode node) {
		int size = 0;
		while(node != null) {
			size++;
			node = node.next;
		}
		return size;
	}

}
