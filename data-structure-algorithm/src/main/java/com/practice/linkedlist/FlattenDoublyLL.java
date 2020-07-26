package com.practice.linkedlist;
/*
Leetcode#430. Flatten a Multilevel Doubly Linked List
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, 
which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, 
and so on, to produce a multilevel data structure, as shown in the example below.
Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
*/
public class FlattenDoublyLL {
    public Node flatten(Node head) {
        if(head != null)
        	recursiveTraversal(head);
        
        return head;
    }
    
    private Node recursiveTraversal(Node theNode) {
    	while(true) {
    		Node tmp = theNode.next;
    		if(theNode.child != null) {
    			theNode.next = theNode.child;
    			theNode.next.prev = theNode;
    			theNode.child = null;
    			Node next = recursiveTraversal(theNode.next);
    			next.next = tmp;
    			if(tmp == null)
    				return next;
    			else
    				tmp.prev = next;
    		}
    		if(tmp == null)
    			return theNode;
    		
    		theNode = tmp;
    	}
    }
}




class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
