package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
		
public class LevelOrderTravesal {
	/*
	Leetcode#102. Binary Tree Level Order Traversal
	Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
	*/
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);

			while (!queue.isEmpty()) {
				int size = queue.size();

				List<Integer> levelValues = new ArrayList<>();
				while (size-- > 0) {
					TreeNode theNode = queue.poll();
					
					levelValues.add(theNode.val);

					if (theNode.left != null)
						queue.offer(theNode.left);

					if (theNode.right != null)
						queue.offer(theNode.right);
				}
				
				result.add(levelValues);
			}
		}

		return result;
	}
	
	/*
	Leetcode#515. Find Largest Value in Each Tree Row
	You need to find the largest value in each row of a binary tree.
	*/
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> largestInRows = new ArrayList<Integer>();

		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);

			while (!queue.isEmpty()) {
				int size = queue.size();

				int largest = Integer.MIN_VALUE;
				while (size-- > 0) {
					TreeNode theNode = queue.poll();

					if (theNode.val > largest)
						largest = theNode.val;

					if (theNode.left != null)
						queue.offer(theNode.left);

					if (theNode.right != null)
						queue.offer(theNode.right);
				}

				largestInRows.add(largest);
			}
		}

		return largestInRows;
	}
	
	/*
	Leetcode#513. Find Bottom Left Tree Value
	Given a binary tree, find the leftmost value in the last row of the tree.
	*/
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
	
	/*
	Leetcode#993. Cousins in Binary Tree
	In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
	Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
	We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
	Return true if and only if the nodes corresponding to the values x and y are cousins.
	*/
	public boolean isCousins(TreeNode root, int x, int y) {
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);

			while (!queue.isEmpty()) {
				int size = queue.size();

				int count = 0;
				while (size-- > 0) {
					TreeNode theNode = queue.poll();
					
					if(theNode.left != null && theNode.right != null) { //To check if children are not from same parent
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
	
	/*
	Leetcode#1161. Maximum Level Sum of a Binary Tree
	Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

	Return the smallest level X such that the sum of all the values of nodes at level X is maximal.
	*/
	public int maxLevelSum(TreeNode root) {
		Queue<TreeNode>  queue = new LinkedList<>();
		queue.offer(root);
		
		int maxSum = 0, minLevel = 0, level = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();

			int sum = 0; ++level;
			while(size-- > 0) {
				TreeNode theNode = queue.poll();
				
				sum = sum + theNode.val;
				
				if(theNode.left != null)
					queue.offer(theNode.left);
				if(theNode.right != null)
					queue.offer(theNode.right);
			}
			
			if(sum > maxSum) {
				maxSum = sum;
				minLevel = level;
			}
		}
		
		return minLevel;
    }
}
