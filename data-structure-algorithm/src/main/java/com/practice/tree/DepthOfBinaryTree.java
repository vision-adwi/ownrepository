package com.practice.tree;
/*
Leetcode#104. Maximum Depth of Binary Tree
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/
public class DepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return findDepth(root, 0);
    }
    
    private int findDepth(TreeNode theNode, int depth) {
        if(theNode == null)
            return depth;
        
        int leftDepth = findDepth(theNode.left, depth);
        int rightDepth = findDepth(theNode.right, depth);
        
        return ((leftDepth > rightDepth) ? leftDepth : rightDepth) + 1;
    }
}
