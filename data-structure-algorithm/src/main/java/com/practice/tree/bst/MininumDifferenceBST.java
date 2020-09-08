package com.practice.tree.bst;

import java.util.LinkedList;

import com.practice.tree.util.TreeNode;
/*
Leetcode#530. Minimum Absolute Difference in BST
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
*/
class MininumDifferenceBST {
	public int getMinimumDifference(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}

		int val = -1;
		int min_diff = Integer.MAX_VALUE;
		while (!stack.isEmpty()) {
			if (val != -1) {
				min_diff = Math.min(min_diff, (stack.peek().val - val));
			}			
			val = stack.peek().val;
			root = stack.pop().right;
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
		}
		
		return min_diff;
	}
}
