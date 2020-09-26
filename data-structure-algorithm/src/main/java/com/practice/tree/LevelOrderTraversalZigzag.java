package com.practice.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.practice.tree.util.TreeNode;
/*
Leetcode#103. Binary Tree Zigzag Level Order Traversal
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, 
then right to left for the next level and alternate between).
*/		
public class LevelOrderTraversalZigzag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<>();
    	if(root == null)
    		return result;
    	
       	Deque<TreeNode> deque = new LinkedList<>();
    	deque.addFirst(root);
    	
    	boolean left = true;
    	while(!deque.isEmpty()) {
    		int size = deque.size();
    		
    		List<Integer> level = new ArrayList<>();
    		while(size-- > 0) {
    			TreeNode theNode = null;
	    		if(left) {
	    			theNode = deque.pollFirst();
	    			if(theNode.left != null) {
	    				deque.offerLast(theNode.left);
	    			}
	    			if(theNode.right != null) {
	    				deque.offerLast(theNode.right);
	    			}
	    		}
	    		else {
	    			theNode = deque.pollLast();
	    			if(theNode.right != null) {
	    				deque.offerFirst(theNode.right);
	    			}
	    			if(theNode.left != null) {
	    				deque.offerFirst(theNode.left);
	    			}
	    		}
	    		level.add(theNode.val);
    		}
    		result.add(level); 
    		left = !left;
    	}
    	
        return result;
    }

}
