package com.practice.tree;
/*
Leetcode#112. Path Sum
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
adding up all the values along the path equals the given sum.
*/
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null)
    		return false;
    	
        return checkSum(root, sum, 0);
    }
    
    private boolean checkSum(TreeNode theNode, int threshold, int sum) {
    	if(theNode == null)
    		return false;
    	
    	if((theNode.left == null) && (theNode.right == null))
    		return (sum + theNode.val) == threshold;
    	
    	boolean check = checkSum(theNode.left, threshold, sum + theNode.val);
    	if(!check)
    		check = checkSum(theNode.right, threshold, sum + theNode.val);
    	
    	return check;
    }
}
