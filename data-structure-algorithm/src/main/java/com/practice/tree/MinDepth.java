package com.practice.tree;
/*
Leetcode#111. Minimum Depth of Binary Tree
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/
public class MinDepth {
    public int minDepth(TreeNode root) {
    	if(root != null)
    		return getMinDepth(root, 0, Integer.MAX_VALUE);
    	else
    		return 0;
    }
    
    private int getMinDepth(TreeNode theNode, int depth, int minDepth) {
    	if(theNode == null) 
    		return minDepth;
    	
    	if(theNode.left == null && theNode.right == null) {
    		return (depth + 1) < minDepth ? (depth + 1) : minDepth;
    	}
    	
    	minDepth = getMinDepth(theNode.left, depth + 1, minDepth);
    	minDepth = getMinDepth(theNode.right, depth + 1, minDepth);
    	
    	return minDepth;
    }
}
