package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Leetcode#102. Binary Tree Level Order Traversal
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
*/		
public class LevelOrderTravesal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);

			List<Integer> levelValues = new ArrayList<>();
			while (!queue.isEmpty()) {
				int size = queue.size();

				while (size-- > 0) {
					TreeNode theNode = queue.poll();
					levelValues.add(theNode.val);

					if (theNode.left != null)
						queue.offer(theNode.left);

					if (theNode.right != null)
						queue.offer(theNode.right);
				}
				result.add(levelValues);
				levelValues = new ArrayList<>();
			}
		}

		return result;
	}
}
