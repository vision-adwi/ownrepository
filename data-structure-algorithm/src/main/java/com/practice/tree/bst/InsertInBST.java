package com.practice.tree.bst;

import com.practice.tree.util.TreeNode;
/*
Leetcode#701. Insert into a Binary Search Tree
Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. 
Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
*/		
public class InsertInBST {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			root = new TreeNode(val);
		} else {
			insert(root, val);
		}
		
		return root;
	}
    
	private void insert(TreeNode theNode, int val) {
		TreeNode node;
		if (val < theNode.val) {
			if ((node = theNode.left) == null) {
				theNode.left = new TreeNode(val);
				return;
			}
		} else {
			if ((node = theNode.right) == null) {
				theNode.right = new TreeNode(val);
				return;
			}
		}

		insert(node, val);
	}
}
