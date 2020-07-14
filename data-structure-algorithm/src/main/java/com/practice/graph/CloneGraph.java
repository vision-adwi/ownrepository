package com.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Leetcode#133. Clone Graph

public class CloneGraph {
	public Node cloneGraph(Node node) {
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
			Node clonedNeighbor = adjMap.get(node.val);
			if(clonedNeighbor == null) {
				clonedNeighbor = new Node(node.val);
				adjMap.put(node.val, clonedNeighbor);
			}
			cloned.neighbors.add(clonedNeighbor);
			
			if(!visited.contains(node.val))
				traverse(node, clonedNeighbor, adjMap, visited);
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
