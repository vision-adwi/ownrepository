package com.practice.tree;

import java.util.Stack;

class BSTIterator {
	Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		if (root != null) {
			stack.push(root);
			while (stack.peek().left != null)
				stack.push(stack.peek().left);
		}
	}
    
    /** @return the next smallest number */
    public int next() {
    	TreeNode current = stack.pop();
    	int data = current.val;
    	
    	current = current.right;
		if (current != null) {
			stack.push(current);
			while (stack.peek().left != null)
				stack.push(stack.peek().left);
		}

        return data;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
