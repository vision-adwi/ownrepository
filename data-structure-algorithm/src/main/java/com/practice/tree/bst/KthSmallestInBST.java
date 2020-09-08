package com.practice.tree.bst;

import java.util.LinkedList;

import com.practice.tree.util.TreeNode;

/*
Leetcode#230. Kth Smallest Element in a BST
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
*/
public class KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stackify(stack, root);
        
        int val = -1;
        while(k-- > 0) {
            val = next(stack);
        }
        
        return val;
    }
    
    private int next(LinkedList<TreeNode> stack) {
        TreeNode current = stack.pop();
        stackify(stack, current.right);
        return current.val;
    }
    
    private void stackify(LinkedList<TreeNode> stack, TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
