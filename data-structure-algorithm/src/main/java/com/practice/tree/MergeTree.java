package com.practice.tree;
/*
Leetcode#617. Merge Two Binary Trees
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. 
Otherwise, the NOT null node will be used as the node of new tree.
*/
public class MergeTree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	if(t1 == null && t2 == null)
    		return null;
        
    	TreeNode resultNode = new TreeNode();
        merge(t1, t2, resultNode, null);
        
        return resultNode;
    }
    
    private void merge(TreeNode nodeOne, TreeNode nodeTwo, TreeNode result, String arm) {
    	if(nodeOne == null && nodeTwo == null)
    		return;
    	
    	if(nodeOne == null && nodeTwo !=null) {
    		setNode(arm, result, nodeTwo);
    		return;
    	}
    	
    	if(nodeTwo == null && nodeOne !=null) {
    		setNode(arm, result, nodeOne);
    		return;
    	}
    	
    	TreeNode newNode = new TreeNode(nodeOne.val + nodeTwo.val);
    	setNode(arm, result, newNode);
    	if(arm != null)
    		result = newNode;

    	merge(nodeOne.left, nodeTwo.left, result, "left");
    	merge(nodeOne.right, nodeTwo.right, result, "right");
    	
    }
    
    private void setNode(String arm, TreeNode result, TreeNode theNode) {
    	if("left".equals(arm)) {
			result.left = theNode;
		}
		else if("right".equals(arm)) {
			result.right = theNode;
		}
		else {
			result.val = theNode.val;
		}
    }
}
