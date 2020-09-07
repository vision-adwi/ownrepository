package com.practice.tree.bst;

import com.practice.tree.util.TreeNode;

//Leetcode#450. Delete Node in a BST

public class DeleteInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
    	TreeNode parent = null;
    	TreeNode theNode = root;
    	while(theNode != null && theNode.val != key) {
    		parent = theNode;
    		if(key < theNode.val) {
    			theNode = theNode.left;
    		}
    		else {
    			theNode = theNode.right;
    		}
    	}
    	
    	if(theNode == null) //If the node to be deleted is not found in the tree
    		return root;

    	if((theNode.left != null) && (theNode.right != null)) {
    		TreeNode pivot = theNode;
    		
    		parent = theNode;
    		theNode = theNode.right;
    		while(theNode.left != null) {
    			parent = theNode;
    			theNode = theNode.left;
    		}
    		
    		theNode.val = pivot.val;

    		deleteNode(parent, theNode, theNode.right);
    		
    	}
    	else {
    		TreeNode child = theNode.left;
    		if(child == null)
    			child = theNode.right;
    		
    		if(parent == null)
    			root = child;
    		else	
    			deleteNode(parent, theNode, child);
    	}
        
    	return root;
    }
    
    private void deleteNode(TreeNode parent, TreeNode theNode, TreeNode child) {
    	if(parent.left == theNode) {
			parent.left = child;
		}
		else {
			parent.right = child;
		}
    }
}
