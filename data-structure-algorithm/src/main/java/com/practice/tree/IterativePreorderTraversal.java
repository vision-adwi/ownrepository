package com.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
Leetcode#144. Binary Tree Preorder Traversal
Given a binary tree, return the preorder traversal of its nodes' values.
*/		
public class IterativePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversedNodes = new ArrayList<>();
        
        if(root != null) {
        	Stack<TreeNode> stack = new Stack<>();
        	TreeNode current = root;

        	while(!stack.isEmpty() || current != null) {
        		while(current != null) {
        			traversedNodes.add(current.val);
        			stack.push(current);
        			current = current.left;
        		}

        		current = stack.pop().right;
        	}
        }

        return traversedNodes;
    }

}
