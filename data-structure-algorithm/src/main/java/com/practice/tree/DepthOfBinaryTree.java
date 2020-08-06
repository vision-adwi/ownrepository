package com.practice.tree;
/*
Leetcode#104. Maximum Depth of Binary Tree
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/
public class DepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
    	if(root == null)
            return 0;
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
