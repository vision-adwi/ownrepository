package com.practice.tree;
/*
Leetcode#993. Cousins in Binary Tree
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.
*/
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeCousin {
	
	public boolean isCousins(TreeNode root, int x, int y) {
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);

			while (!queue.isEmpty()) {
				int size = queue.size();

				int count = 0;
				while (size-- > 0) {
					TreeNode theNode = queue.poll();
					if(theNode.left != null && theNode.right != null) {
						if((theNode.left.val == x || theNode.left.val == y) &&
							(theNode.right.val == x || theNode.right.val == y)) {
							return false;
						}
					}

					if(theNode.val == x || theNode.val == y) {
						count++;
					}
					if(count == 2)
						return true;
					if (theNode.left != null)
						queue.offer(theNode.left);

					if (theNode.right != null)
						queue.offer(theNode.right);
				}
			}
		}

		return false;
	}

}
