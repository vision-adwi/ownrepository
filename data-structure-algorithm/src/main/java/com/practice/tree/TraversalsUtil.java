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
		LinkedList<TreeNode> stack = new LinkedList<>();

		while(true) {
			while(root != null) {
				result.add(root.val);
				stack.push(root);
				root = root.left;
			}
			if(stack.isEmpty())
				break;
			
			root = stack.pop().right;
		}

		return result;
    }
	
	/*
	Leetcode#94. Binary Tree Inorder Traversal
	Given a binary tree, return the inorder traversal of its nodes' values.
	*/
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();

		while(true) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			if(stack.isEmpty())
				break;
			
            result.add(stack.peek().val);
			root = stack.pop().right;
		}

		return result;
    }
	
	/*
	Leetcode#145. Binary Tree Postorder Traversal
	Given a binary tree, return the postorder traversal of its nodes' values.
	*/
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();

		while(true) {
			while(root != null) {
				result.add(0, root.val);
				stack.push(root);
				root = root.right;
			}
            if(stack.isEmpty())
                break;
            
            root = stack.pop().left;
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
    		LinkedList<Node> stack = new LinkedList<>();
    		stack.push(root);
    		while(!stack.isEmpty()) {
    			Node node = stack.pop();
    			result.add(0, node.val);
    			for(Node child : node.children) {
    				stack.push(child);
    			}
    		}
    	}
    	
    	return result;       
    }

}
