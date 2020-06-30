package com.practice.tree;

public class MergeTree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode resultNode = new TreeNode();
        if(t1 != null || t2 != null)
        	merge(t1, t2, resultNode);
        
        return resultNode;
    }
    
    private void merge(TreeNode nodeOne, TreeNode nodeTwo, TreeNode result) {
    	int sum = (nodeOne == null ? 0 : nodeOne.val) + 
    			(nodeTwo == null ? 0 : nodeTwo.val);
    	result.val = sum;
    	
    	TreeNode theNode = new TreeNode();
    	
    	TreeNode leftOne = nodeOne == null ? null : nodeOne.left;
    	TreeNode leftTwo = nodeTwo == null ? null : nodeTwo.left;
    	if(leftOne != null || leftTwo != null) {
    		result.left = theNode;
    		merge(leftOne, leftTwo, result.left);
    	}
    	
    	TreeNode rightOne = nodeOne == null ? null : nodeOne.right;
    	TreeNode rightTwo = nodeTwo == null ? null : nodeTwo.right;
    	if(rightOne != null || rightTwo != null) {
    		result.right = theNode;
    		merge(rightOne, rightTwo, result.right);
    	}
    	
    }
}
