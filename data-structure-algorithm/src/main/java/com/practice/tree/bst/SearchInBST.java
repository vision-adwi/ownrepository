package com.practice.tree.bst;

import com.practice.tree.util.TreeNode;
/*
Leetcode#700. Search in a Binary Search Tree
Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the 
node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
*/
public class SearchInBST {
	public TreeNode searchBST(TreeNode root, int val) {
		if(root == null)
			return null;
		
		if(root.val == val)
			return root;
		
		if(val < root.val) {
			return searchBST(root.left, val);
		}
		else {
			return searchBST(root.right, val);
		}
        
    }
}
