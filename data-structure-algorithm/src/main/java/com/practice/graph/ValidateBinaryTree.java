package com.practice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBinaryTree {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    	Queue<Integer> queue = new LinkedList<>();
    	boolean[] visited = new boolean[n];
    	
    	int pointer = 0;
    	
    	queue.offer(0);
    	visited[0] = true;
    	while(!queue.isEmpty()) {
    		queue.poll();
    		int leftNode = leftChild[pointer];
    		if(leftNode != -1) {
    			if(visited[leftNode]) {
    				return false;
    			}
    			queue.offer(leftNode);
    			visited[leftNode] = true;
    		}
    		
    		int rightNode = rightChild[pointer];
    		if(rightNode != -1) {
    			if(visited[rightNode]) {
    				return false;
    			}
    			queue.offer(rightNode);
    			visited[rightNode] = true;
    		}
    		
    		pointer++;
    	}
    	
    	return pointer < n;
        
    }
    
    public static void main(String[] s) {
    	ValidateBinaryTree tree = new ValidateBinaryTree();
    	tree.validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[] {2,-1,-1,-1});
    }
}
