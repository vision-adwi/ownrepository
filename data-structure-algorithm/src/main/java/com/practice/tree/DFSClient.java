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
    	DFSTreeUtil.checkSum(root, sum, 0, new ArrayList<>(), result);
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
	Leetcode#1325. Delete Leaves With a Given Value
	Given a binary tree root and an integer target, delete all the leaf nodes with value target.

	Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the value target, 
	it should also be deleted (you need to continue doing that until you can't).
	*/
	public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode modifiedRoot = root;
        if(DFSTreeUtil.delete(root, target))
        	modifiedRoot = null;
        
        return modifiedRoot;
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
}
