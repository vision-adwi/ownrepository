package com.practice.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.practice.tree.util.Node;
import com.practice.tree.util.TreeNode;

public class TraversalsUtil {
	/*
	Leetcode#144. Binary Tree Preorder Traversal
	Given a binary tree, return the preorder traversal of its nodes' values.
	*/	
	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root != null) {
        	Stack<TreeNode> stack = new Stack<>();
        	TreeNode current = root;

        	while(!stack.isEmpty() || current != null) {
        		while(current != null) {
        			result.add(current.val);
        			stack.push(current);
        			current = current.left;
        		}

        		current = stack.pop().right;
        	}
        }

        return result;
    }
	
	/*
	Leetcode#94. Binary Tree Inorder Traversal
	Given a binary tree, return the inorder traversal of its nodes' values.
	*/
	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversedNodes = new ArrayList<>();
        
        if(root != null) {
        	Stack<TreeNode> stack = new Stack<>();
        	TreeNode current = root;

        	while(!stack.isEmpty() || current != null) {
        		while(current != null) {
        			stack.push(current);
        			current = current.left;
        		}
        		
        		current = stack.pop();
        		traversedNodes.add(current.val);
        		current = current.right;
        	}
        }

        return traversedNodes;
    }
	
	/*
	Leetcode#145. Binary Tree Postorder Traversal
	Given a binary tree, return the postorder traversal of its nodes' values.
	*/	
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		
		if(root != null) {
			Stack<TreeNode> stack = new Stack<>();
			TreeNode current = root;
			
			while(!stack.isEmpty() || current != null) {
				while(current != null) {
					result.add(current.val);
					stack.push(current);
					current = current.right;
				}
				
				current = stack.pop().left;
			}
			
			Collections.reverse(result);
		}
        
		return result;
    }
	
	/*
	Leetcode#589. N-ary Tree Preorder Traversal
	*/
    public List<Integer> preorder(Node root) {
    	List<Integer> result = new LinkedList<>();
    	if(root != null) {
    		Stack<Node> stack = new Stack<>();
    		stack.push(root);
    		while(!stack.isEmpty()) {
    			Node node = stack.pop();
    			result.add(node.val);
    			Collections.reverse(node.children);
    			for(Node child : node.children) {
    				stack.push(child);
    			}
    		}
    	}
    	
        return result;
    }
	
	/*
	Leetcode#590. N-ary Tree Postorder Traversal
	*/
    public static List<Integer> postorder(Node root) {
    	List<Integer> result = new LinkedList<>();
    	if(root != null) {
    		Stack<Node> stack = new Stack<>();
    		stack.push(root);
    		while(!stack.isEmpty()) {
    			Node node = stack.pop();
    			result.add(node.val);
    			for(Node child : node.children) {
    				stack.push(child);
    			}
    		}
    		
    		Collections.reverse(result);
    	}
    	
    	return result;       
    }

}
