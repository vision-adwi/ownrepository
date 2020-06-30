package com.practice.tree;

import java.util.ArrayList;
import java.util.List;

/*
Leetcode#113. Path Sum II
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
*/
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> result = new ArrayList<>();
    	checkSum(root, sum, 0, new ArrayList<>(), result);
    	return result;
    }
    
    private void checkSum(TreeNode theNode, int threshold, int sum, List<Integer> aPath, List<List<Integer>> paths) {
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
}
