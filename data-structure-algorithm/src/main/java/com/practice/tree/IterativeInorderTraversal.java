package com.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
Leetcode#94. Binary Tree Inorder Traversal
Given a binary tree, return the inorder traversal of its nodes' values.
*/		
public class IterativeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversedNodes = new ArrayList<>();
        
        if(root != null) {
        	Stack<TreeNode> stack = new Stack<>();
        	TreeNode current = root;

        	while(!stack.isEmpty() || current != null) {
        		while(current != null) {
        			stack.push(current);
        			current = current.left;
        		}
        		
        		current = stack.pop();
        		traversedNodes.add(current.val);
        		current = current.right;
        	}
        }

        return traversedNodes;
    }

}
