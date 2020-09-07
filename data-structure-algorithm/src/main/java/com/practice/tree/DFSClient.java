package com.practice.tree;

import java.util.ArrayList;
import java.util.List;

import com.practice.tree.util.TreeNode;

public class DFSClient {
	/*
	Leetcode#129. Sum Root to Leaf Numbers
	Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
	An example is the root-to-leaf path 1->2->3 which represents the number 123.
	Find the total sum of all root-to-leaf numbers.
	*/
	public int sumNumbers(TreeNode root) {
        return DFSTreeUtil.getSum(root, 0);
    }
	
	/*
	Leetcode#112. Path Sum
	Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
	adding up all the values along the path equals the given sum.
	*/
	public boolean hasPathSum(TreeNode theNode, int sum) {
		return DFSTreeUtil.hasPathSum(theNode, sum);
	}
	
	/*
	Leetcode#113. Path Sum II
	Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
	*/
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> result = new ArrayList<>();
    	DFSTreeUtil.checkSum(root, sum, new ArrayList<>(), result);
    	return result;
    }
	
	/*
	Leetcode#404. Sum of Left Leaves
	Find the sum of all left leaves in a given binary tree.
	*/
	public int sumOfLeftLeaves(TreeNode root) {
        return DFSTreeUtil.findNextLeaves(root, true);
    }

	/*
	Leetcode#257. Binary Tree Paths
	Given a binary tree, return all root-to-leaf paths.
	*/	
	public List<String> binaryTreePaths(TreeNode root) {
    	List<String> paths = new ArrayList<>();
    	DFSTreeUtil.allPaths(root, paths, new ArrayList<>());
        
    	return paths;
    }
	
    /*
    Leetcode#101. Symmetric Tree
    */
	public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        return DFSTreeUtil.checkSymmetry(root.left, root.right);
    }
}
