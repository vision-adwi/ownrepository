package com.practice.tree;

import com.practice.tree.util.TreeNode;
/*
Leetcode#105. Construct Binary Tree from Preorder and Inorder Traversal
Given preorder and inorder traversal of a tree, construct the binary tree.
*/
public class TreeFromInAndPreOrder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return subtree(0, inorder.length - 1, 0, preorder, inorder);
    }	
	
	private TreeNode subtree(int inStart, int inEnd, int preIndex, int[] preorder, int[] inorder) {
		if(inStart > inEnd)
			return null;
		
		int inOrderIndex = inStart;
		while(preorder[preIndex] != inorder[inOrderIndex]) {
			inOrderIndex++;
		}
		
		TreeNode node = new TreeNode(preorder[preIndex]);
		node.left = subtree(inStart, inOrderIndex - 1, preIndex + 1, preorder, inorder);
		node.right = subtree(inOrderIndex + 1, inEnd, preIndex + (inOrderIndex - inStart) + 1, preorder, inorder);
		
		return node;
	}
}
