package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
