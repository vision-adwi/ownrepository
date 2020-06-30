package com.practice.tree;
/*
Leetcode#100. Same Tree
Given two binary trees, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
*/
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);
    }
    
    private boolean compare(TreeNode p, TreeNode q) {
    	if(p == null)
    		return q == null;
    	
    	if(q == null)
   			return false;
    	
    	if(p.val != q.val)
    		return false;
    	
    	boolean isSame = compare(p.left, q.left);
    	if(isSame)
    		isSame = compare(p.right, q.right);
    	
    	return isSame;
    }
}
