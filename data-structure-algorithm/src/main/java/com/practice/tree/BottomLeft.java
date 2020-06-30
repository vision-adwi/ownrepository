package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;
/*
Leetcode#513. Find Bottom Left Tree Value
Given a binary tree, find the leftmost value in the last row of the tree.
*/
public class BottomLeft {
	public int findBottomLeftValue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		int bottomLeftMost = root.val;
		while (!queue.isEmpty()) {
			int size = queue.size();

			boolean captured = false;
			while (size-- > 0) {
				TreeNode theNode = queue.poll();

				if (!captured) {
					bottomLeftMost = theNode.val;
					captured = true;
				}

				if (theNode.left != null)
					queue.offer(theNode.left);

				if (theNode.right != null)
					queue.offer(theNode.right);
			}
		}

		return bottomLeftMost;
	}
}
