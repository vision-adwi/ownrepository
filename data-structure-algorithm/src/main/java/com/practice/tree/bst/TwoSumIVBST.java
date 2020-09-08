package com.practice.tree.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.practice.tree.util.TreeNode;

/*
Leetcode#653. Two Sum IV - Input is a BST
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
*/		
public class TwoSumIVBST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(true) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            
            if(stack.isEmpty())
                break;
            
            list.add(stack.peek().val);
            root = stack.pop().right;
        }
        
        if(list.size() < 2)
            return false;
        
        int j = list.size() - 1;
        int i = 0;
        int val = Integer.MIN_VALUE;
        while(i < j) {            
            val = list.get(i) + list.get(j);
            if(val == k)
                return true;
            if(val > k) {
                j--;
                continue;
            }
            i++;
        }
        
        return false;
    }
}
