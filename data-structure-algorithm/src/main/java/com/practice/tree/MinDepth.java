package com.practice.tree;

public class MinDepth {
    public int minDepth(TreeNode root) {
        return getMinDepth(root, 0, Integer.MAX_VALUE);
    }
    
    private int getMinDepth(TreeNode theNode, int depth, int minDepth) {
    	if(theNode == null) 
    		return depth < minDepth ? depth : minDepth;
    	
    	minDepth = getMinDepth(theNode.left, depth + 1, minDepth);
    	minDepth = getMinDepth(theNode.right, depth + 1, minDepth);
    	
    	return minDepth;
    }
}
