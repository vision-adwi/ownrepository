package com.practice.tree;

import com.practice.tree.util.Node;
import com.practice.tree.util.TreeNode;

public class TreeUtil {
	//#1038 leetcode - See later
	
	/*
	Leetcode#559. Maximum Depth of N-ary Tree
	Given a n-ary tree, find its maximum depth.
	The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
	*/
	public int maxDepth(Node root) {
        if(root == null)
        	return 0;
        
        int depth = 0;
        for(Node child : root.children) {
        	int childDepth = maxDepth(child);
        	depth = Math.max(depth, childDepth);       			
        }
        
        return depth + 1;
    }
	
	/*
	Leetcode#104. Maximum Depth of Binary Tree
	Given a binary tree, find its maximum depth.
	The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	*/
    public int maxDepth(TreeNode root) {
    	if(root == null)
            return 0;
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    /*
    Leetcode#111. Minimum Depth of Binary Tree
    Given a binary tree, find its minimum depth.
    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
    */
    public int minDepth(TreeNode root) {
    	int depth = 0;
    	if(root != null)
    		depth = getMinDepth(root, depth, Integer.MAX_VALUE);

    	return depth;
    }
    
    private int getMinDepth(TreeNode theNode, int depth, int minDepth) {
    	if(theNode == null) 
    		return minDepth;
    	
    	depth++;
    	if(theNode.left == null && theNode.right == null) {
    		return Math.min((depth), minDepth);
    	}
    	
    	minDepth = getMinDepth(theNode.left, depth, minDepth);
    	minDepth = getMinDepth(theNode.right, depth, minDepth);
    	
    	return minDepth;
    }
    
	/*
	Leetcode#226. Invert Binary Tree
	*/
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
    
    /*
    Leetcode#222. Count Complete Tree Nodes
    Given a complete binary tree, count the number of nodes.
    */
	public int countNodes(TreeNode root) {
		if(root == null)
			return 0;
		
		int rightDepth = findDepth(root, true);
		int leftDepth = findDepth(root, false);
		
		if(leftDepth == rightDepth) {
			return (2 << leftDepth) - 1;
		}
		
		int rightCount = countNodes(root.right);
		int leftCount = countNodes(root.left);
		
		return rightCount + leftCount + 1;
	}
	
	private int findDepth(TreeNode node, boolean rightArm) {
		int depth = -1;
		while(node != null) {
			node = rightArm ? node.right : node.left;
			depth++;
		}
		
		return depth;
	}

}
