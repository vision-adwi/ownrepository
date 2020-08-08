package com.practice.tree;

import com.practice.tree.util.Node;

/*
Leetcode#559. Maximum Depth of N-ary Tree
Given a n-ary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
*/
public class NaryDepth {
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

}
