package com.practice.tree;

import com.practice.tree.util.TreeNode;
/*
Leetcode#106. Construct Binary Tree from Inorder and Postorder Traversal
*/
public class TreeFromInAndPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return subtree(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }
    
    private TreeNode subtree(int[] inorder, int[] postorder, int inStart, int inEnd, int postIndex) {
    	if(inStart > inEnd)
    		return null;
    		
    	int inOrderIndex = inStart;
    	while(inorder[inOrderIndex] != postorder[postIndex])
    		inOrderIndex++;
    	
    	TreeNode node = new TreeNode(inorder[inOrderIndex]);
    	node.right = subtree(inorder, postorder, inOrderIndex + 1, inEnd, postIndex - 1);
    	node.left = subtree(inorder, postorder, inStart, inOrderIndex - 1, postIndex - (inEnd - inOrderIndex) - 1);
    	
    	return node;
    }
}
