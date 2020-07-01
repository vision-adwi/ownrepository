package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Leetcode#429. N-ary Tree Level Order Traversal
Given an n-ary tree, return the level order traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal, each group of children 
is separated by the null value (See examples).
*/
public class NaryLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
    	List<List<Integer>> result = new ArrayList<>();
    	if(root == null)
    		return result;
    	
    	Queue<Node> queue = new LinkedList<>();
    	queue.offer(root);
    	
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		
    		List<Integer> row = new ArrayList<>();
    		while(size-- > 0) {
    			Node theNode = queue.poll();
    			row.add(theNode.val);
    			
    			for(Node node : theNode.children) {
    				queue.offer(node);
    			}
    		}
    		
    		result.add(row);
    	}
        
    	return result;
    }
}
