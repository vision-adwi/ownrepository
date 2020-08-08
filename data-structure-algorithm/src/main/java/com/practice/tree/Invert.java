package com.practice.tree;

import com.practice.tree.util.TreeNode;

//Leetcode#226. Invert Binary Tree

public class Invert {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    
    private void invert(TreeNode theNode) {
    	if(theNode == null)
    		return;
    	
    	TreeNode temp = theNode.left;
    	theNode.left = theNode.right;
    	theNode.right = temp;
    	
    	invert(theNode.left);
    	invert(theNode.right);
    }

}
