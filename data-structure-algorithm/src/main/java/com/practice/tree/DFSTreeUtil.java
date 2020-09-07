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
    	
    	number = (number * 10) + theNode.val;
    	if((theNode.left == null) && (theNode.right == null)) //to check leaf node
    		return number;

    	int leftNum = getSum(theNode.left, number);
    	int rightNum = getSum(theNode.right, number);
    	
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
    	
    	sum = sum - theNode.val;
    	if((theNode.left == null) && (theNode.right == null)) //to check leaf node
    		return sum == 0;

    	if(hasPathSum(theNode.left, sum))
    		return true;
    	
    	return hasPathSum(theNode.right, sum);
    }
    
    /*
    Leetcode#113. Path Sum II
    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
    */
    public static void checkSum(TreeNode theNode, int sum, List<Integer> aPath, List<List<Integer>> paths) {
    	if(theNode == null)
    		return;
    	
    	aPath.add(theNode.val);
    	sum = sum - theNode.val;
    	if((theNode.left == null) && (theNode.right == null)) {//to check leaf node
    		if(sum == 0) {
    			paths.add(new ArrayList<>(aPath));
    		}
    		aPath.remove(aPath.size() - 1);
    		return;
    	}

    	checkSum(theNode.left, sum, aPath, paths);
    	checkSum(theNode.right, sum, aPath, paths);
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
	Leetcode#257. Binary Tree Paths
	Given a binary tree, return all root-to-leaf paths.
	*/	
    public static void allPaths(TreeNode theNode, List<String> result, List<Integer> current) {
    	if(theNode == null)
    		return;
    	
    	current.add(theNode.val);
    	if(theNode.left == null && theNode.right == null) {   		
    		result.add(buildString(current));
    		current.remove(current.size() - 1);
    		return;
    	}

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
    
    /*
    Leetcode#101. Symmetric Tree
    */
    public static boolean checkSymmetry(TreeNode left, TreeNode right) {
        if(left == null)
            return right == null;
        else if(right == null)
            return false;
        else if(left.val != right.val)
            return false;
            
        if(!checkSymmetry(left.left, right.right))
            return false;
        
        return checkSymmetry(left.right, right.left);
    }
    
	/*
	Leetcode#1325. Delete Leaves With a Given Value
	Given a binary tree root and an integer target, delete all the leaf nodes with value target.

	Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the value target, 
	it should also be deleted (you need to continue doing that until you can't).
	*/
	public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null)
			return null;
		
		if(root.left == null && root.right == null && root.val == target)
			return null;
				
		root.left = removeLeafNodes(root.left, target);
		root.right = removeLeafNodes(root.right, target);
        
        if(root.left == null && root.right == null && root.val == target)
			return null;
		
		return root;
    }
    
    private static String buildString(List<Integer> paths) {
    	StringBuilder builder = new StringBuilder();
    	
    	builder.append(paths.get(0));
    	for(int i = 1; i < paths.size(); i++) {
    		builder.append("->");
    		builder.append(paths.get(i));
    	}
    
    	return builder.toString();
    }
}


