package com.practice.tree.bst;
import java.util.LinkedList;
import com.practice.tree.util.TreeNode;

/*
Leetcode#173. Binary Search Tree Iterator
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.
*/
class BSTIterator {
	LinkedList<TreeNode> stack;
	public BSTIterator(TreeNode root) {
		stack = new LinkedList<>();
		stackify(root);
	}
    
    /** @return the next smallest number */
    public int next() {
    	TreeNode current = stack.pop();   	
    	stackify(current.right);

        return current.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void stackify(TreeNode node) {
    	while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
