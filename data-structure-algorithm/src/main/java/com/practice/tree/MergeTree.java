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
        if(t1 == null) {
    		if(t2 == null) {
    			return null;
    		}
    		else {
    			return t2;
    		}
    	}
    	else {
    		if(t2 == null) {
    			return t1;
    		}
    	}

    	TreeNode newNode = new TreeNode(t1.val + t2.val);

    	newNode.left = mergeTrees(t1.left, t2.left);
    	newNode.right = mergeTrees(t1.right, t2.right);

    	return newNode; 
    }
}
