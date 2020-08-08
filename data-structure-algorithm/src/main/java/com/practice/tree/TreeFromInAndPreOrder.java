package com.practice.tree;

import java.util.Stack;

import com.practice.tree.util.TreeNode;

public class TreeFromInAndPreOrder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode tree = null;
		TreeNode currNode = null;
		Stack<Integer> stack = new Stack<>();
		int preIndex = 0;
		int inIndex = 0;
		
		int current = preorder[preIndex];
		
		while(inorder[inIndex] != current) {
			stack.push(inorder[inIndex++]);
		}
		
		if(tree == null) {
			tree = new TreeNode(current);
			currNode = tree;
		}
		
		currNode.left = new TreeNode(current);
		current = stack.pop();
		
        return tree;
    }		
}
