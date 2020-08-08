package com.practice.tree;

import com.practice.tree.util.TreeNode;
/*
Leetcode#222. Count Complete Tree Nodes
Given a complete binary tree, count the number of nodes.
*/
public class NodeCountOfCompleteBinaryTree {
	public int countNodes(TreeNode root) {
		if(root == null)
			return 0;
		
		int rightDepth = rightDepth(root);
		int leftDepth = leftDepth(root);
		
		if(leftDepth == rightDepth) {
			return (2 << leftDepth) - 1;
		}
		
		int rightCount = countNodes(root.right);
		int leftCount = countNodes(root.left);
		
		return rightCount + leftCount + 1;
	}
	
	private int rightDepth(TreeNode node) {
		int depth = -1;
		while(node != null) {
			node = node.right;
			depth++;
		}
		
		return depth;
	}
	
	private int leftDepth(TreeNode node) {
		int depth = -1;
		while(node != null) {
			node = node.left;
			depth++;
		}
		
		return depth;
	}
}
