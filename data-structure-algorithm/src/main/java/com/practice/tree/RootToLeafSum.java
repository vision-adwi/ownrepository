package com.practice.tree;
/*
Leetcode#129. Sum Root to Leaf Numbers
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.
*/
public class RootToLeafSum {
    public int sumNumbers(TreeNode root) {
        return getSum(root, 0);
    }
    
    private int getSum(TreeNode theNode, int number) {
    	if(theNode == null)
    		return 0;
    	
    	if((theNode.left == null) && (theNode.right == null))
    		return (number * 10) + theNode.val;
    	
    	int leftNum = getSum(theNode.left, (number * 10) + theNode.val);
    	int rightNum = getSum(theNode.right, (number * 10) + theNode.val);
    	
    	return leftNum + rightNum;
    }
}
