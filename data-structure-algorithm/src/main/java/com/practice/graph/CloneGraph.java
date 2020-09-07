 package com.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//Leetcode#133. Clone Graph

public class CloneGraph {
	public Node cloneGraph_bfs(Node node) {
		if(node == null)
			return node;
		
		Node clonedNode = new Node(node.val);		
		Map<Integer, Node> clonedGraph = new HashMap<>();
		clonedGraph.put(node.val, clonedNode);
		
		Set<Integer> visited = new HashSet<>();
		Queue<Node> queue = new LinkedList<>();
		visited.add(node.val);
		queue.offer(node);
		
		while(!queue.isEmpty()) {
			Node theNode = queue.poll();
			for(Node neighbor : theNode.neighbors) {
				clonedGraph.putIfAbsent(neighbor.val, new Node(neighbor.val));
				clonedGraph.get(theNode.val).neighbors.add(clonedGraph.get(neighbor.val));
				
				if(!visited.contains(neighbor.val)) {
					visited.add(neighbor.val);
					queue.offer(neighbor);
				}
					
			}
		}
				
		return clonedNode;
	}
	
	
	public Node cloneGraph_dfs(Node node) {
		if(node == null)
			return node;
		
		Map<Integer, Node> adjMap = new HashMap<>();
		Node clonedNode = new Node(node.val);
		adjMap.put(node.val, clonedNode);
		traverse(node, clonedNode, adjMap, new HashSet<>());
        
		return clonedNode;
    }
	
	private void traverse(Node original, Node cloned, Map<Integer, Node> adjMap, Set<Integer> visited) {
		visited.add(original.val);
		
		for(Node node : original.neighbors) {
			adjMap.putIfAbsent(node.val, new Node(node.val));
			cloned.neighbors.add(adjMap.get(node.val));
			
			if(!visited.contains(node.val))
				traverse(node, adjMap.get(node.val), adjMap, visited);
		}
	}
}

class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
