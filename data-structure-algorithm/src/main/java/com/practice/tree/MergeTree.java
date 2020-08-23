package com.practice.tree;

import com.practice.tree.util.TreeNode;

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
        
    	TreeNode mergedNode = new TreeNode();
        merge(t1, t2, mergedNode, null);
        
        return mergedNode;
    }
    
    private void merge(TreeNode nodeOne, TreeNode nodeTwo, TreeNode merged, String arm) {
    	if(nodeOne == null && nodeTwo == null)
    		return;
    	
    	if(nodeOne == null && nodeTwo !=null) {
    		setNode(arm, merged, nodeTwo);
    		return;
    	}
    	
    	if(nodeTwo == null && nodeOne !=null) {
    		setNode(arm, merged, nodeOne);
    		return;
    	}
    	
    	TreeNode newNode = new TreeNode(nodeOne.val + nodeTwo.val);
    	setNode(arm, merged, newNode);
    	if(arm != null)
    		merged = newNode;

    	merge(nodeOne.left, nodeTwo.left, merged, "left");
    	merge(nodeOne.right, nodeTwo.right, merged, "right");
    	
    }
    
    private void setNode(String arm, TreeNode mergedNode, TreeNode theNode) {
    	if("left".equals(arm)) {
			mergedNode.left = theNode;
		}
		else if("right".equals(arm)) {
			mergedNode.right = theNode;
		}
		else {
			mergedNode.val = theNode.val;
		}
    }
}
