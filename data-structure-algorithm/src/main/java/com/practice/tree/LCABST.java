package com.practice.tree;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode#235. Lowest Common Ancestor of a Binary Search Tree
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node 
in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
	*/	
public class LCABST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        search(root, p, pathP);
        search(root, q, pathQ);
        
        TreeNode ancestor = null; 
        int index = 0;
        for(TreeNode path : pathP) {
        	if(index >= pathQ.size() || path != pathQ.get(index++))
        		break;
        	
        	ancestor = path;
        }
        
        return ancestor;
    }
	
	private void search(TreeNode theNode, TreeNode target, List<TreeNode> path) {
		if(theNode == null)
			return;
		
		path.add(theNode);
		if(theNode == target) {
			return;
		}
		if(target.val < theNode.val) {
			search(theNode.left, target, path);
		}
		else {
			search(theNode.right, target, path);
		}
	}
	
	public static void main(String[] s) {
		TreeNode root = new TreeNode(6);
		
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(8);
		root.left = left;
		root.right = right;
		
		LCABST lca = new LCABST();
		lca.lowestCommonAncestor(root, left, right);
	}

}
