package com.practice.tree.bst;

import java.util.Stack;

import com.practice.tree.TreeNode;
/*
Leetcode#98. Validate Binary Search Tree
*/
public class BSTValiadtion {
	public boolean isValidBST(TreeNode root) {
		Stack<Integer> stack = new Stack<>();
		return validation(root, stack);
        
    }
	
	private boolean validation(TreeNode theNode, Stack<Integer> stack) {
		if (theNode == null)
			return true;

		if (!validation(theNode.left, stack))
			return false;

		if (!stack.isEmpty() && stack.pop() >= theNode.val)
			return false;
		stack.push(theNode.val);

		return validation(theNode.right, stack);
	}
}
