package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Leetcode#515. Find Largest Value in Each Tree Row
You need to find the largest value in each row of a binary tree.
*/
public class LargestEachRow {
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
}
