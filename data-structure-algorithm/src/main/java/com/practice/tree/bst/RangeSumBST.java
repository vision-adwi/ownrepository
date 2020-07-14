package com.practice.tree.bst;

import com.practice.tree.TreeNode;

/*
Leetcode#938. Range Sum of BST
Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
The binary search tree is guaranteed to have unique values.
*/
public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        return rangeSum(root, L, R, 0);
    }
    
    private int rangeSum(TreeNode theNode, int L, int R, int sum) {
        if(theNode == null) {
            return sum;
        }
        
        if(theNode.val > L)
            sum = rangeSum(theNode.left, L, R, sum);
        
        if(theNode.val <= R && theNode.val >= L)
            sum = sum + theNode.val;
        
        if(theNode.val < R)
            sum = rangeSum(theNode.right, L, R, sum);
        
        return sum;
    }
}
