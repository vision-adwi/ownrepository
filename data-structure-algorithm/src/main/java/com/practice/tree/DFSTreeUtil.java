package com.practice.tree;

import java.util.ArrayList;
import java.util.List;

import com.practice.tree.util.TreeNode;

public class DFSTreeUtil {
	/*
	Leetcode#129. Sum Root to Leaf Numbers
	Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
	An example is the root-to-leaf path 1->2->3 which represents the number 123.
	Find the total sum of all root-to-leaf numbers.
	*/
    public static int getSum(TreeNode theNode, int number) {
    	if(theNode == null)
    		return 0;
    	
    	if((theNode.left == null) && (theNode.right == null)) //to check leaf node
    		return (number * 10) + theNode.val;
    	
    	int leftNum = getSum(theNode.left, (number * 10) + theNode.val);
    	int rightNum = getSum(theNode.right, (number * 10) + theNode.val);
    	
    	return leftNum + rightNum;
    }
    
    /*
    Leetcode#112. Path Sum
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
    adding up all the values along the path equals the given sum.
    */
    public static boolean hasPathSum(TreeNode theNode, int sum) {
    	if(theNode == null)
    		return false;
    	
    	if((theNode.left == null) && (theNode.right == null)) //to check leaf node
    		return (sum - theNode.val) == 0;
    	
    	boolean check = hasPathSum(theNode.left, sum - theNode.val);
    	if(!check)
    		check = hasPathSum(theNode.right, sum - theNode.val);
    	
    	return check;
    }
    
    /*
    Leetcode#113. Path Sum II
    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
    */
    public static void checkSum(TreeNode theNode, int threshold, int sum, List<Integer> aPath, List<List<Integer>> paths) {
    	if(theNode == null)
    		return;
    	
    	if((theNode.left == null) && (theNode.right == null)) {
    		if((sum + theNode.val) == threshold) {
    			aPath.add(theNode.val);
    			paths.add(new ArrayList<>(aPath));
    			aPath.remove(aPath.size() - 1);
    		}
    		return;
    	}
    	
    	aPath.add(theNode.val);
    	checkSum(theNode.left, threshold, sum + theNode.val, aPath, paths);
    	checkSum(theNode.right, threshold, sum + theNode.val, aPath, paths);
    	aPath.remove(aPath.size() - 1);
    }

    /*
    Leetcode#404. Sum of Left Leaves
    Find the sum of all left leaves in a given binary tree.
    */
	public static int findNextLeaves(TreeNode theNode, boolean isLeft) {
		if(theNode == null)
			return 0;
		
		if(isLeft && ((theNode.left == null) && (theNode.right == null))) {
			return theNode.val;
		}
		
		int l1 = findNextLeaves(theNode.left, true);
		int l2 = findNextLeaves(theNode.right, false);
		
		return l1 + l2;
	}
	
	/*
	Leetcode#1325. Delete Leaves With a Given Value
	Given a binary tree root and an integer target, delete all the leaf nodes with value target.

	Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the value target, 
	it should also be deleted (you need to continue doing that until you can't).
	*/
	public static boolean delete(TreeNode theNode, int target) {
		if(theNode == null)
			return false;
		
		if((theNode.left == null) && (theNode.right == null) && (theNode.val == target)) {
			return true;
		}
		
		boolean toDelete = delete(theNode.left, target);
		if(toDelete)
			theNode.left = null;
		
		toDelete = delete(theNode.right, target);
		if(toDelete)
			theNode.right = null;
		
		if((theNode.left == null) && (theNode.right == null) && (theNode.val == target)) 
			return true;
		else
			return false;
	}
	
	/*
	Leetcode#257. Binary Tree Paths
	Given a binary tree, return all root-to-leaf paths.
	*/	
    public static void allPaths(TreeNode theNode, List<String> result, List<Integer> current) {
    	if(theNode == null)
    		return;
    	
    	if(theNode.left == null && theNode.right == null) {
    		current.add(theNode.val);
    		result.add(buildString(current));
    		current.remove(current.size() - 1);
    		return;
    	}
    	
    	current.add(theNode.val);
    	allPaths(theNode.left, result, current);
    	allPaths(theNode.right, result, current);
    	current.remove(current.size() - 1);
    }
    
    /*
    Leetcode#100. Same Tree
    Given two binary trees, write a function to check if they are the same or not.
    Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
    */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
    	if(p == null)
    		return q == null;
    	
    	if(q == null)
   			return false;
    	
    	if(p.val != q.val)
    		return false;
    	
    	boolean isSame = isSameTree(p.left, q.left);
    	if(isSame)
    		isSame = isSameTree(p.right, q.right);
    	
    	return isSame;
    }
    
    private static String buildString(List<Integer> paths) {
    	StringBuilder builder = new StringBuilder();
    	for(Integer path : paths) {
    		if(builder.length() != 0)
    			builder.append("->");
    		
    		builder.append(path);
    	}
    
    	return builder.toString();
    }
}


