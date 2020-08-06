package com.practice.graph;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode#802. Find Eventual Safe States
In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  
If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.
Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  
More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.
Which nodes are eventually safe?  Return them as an array in sorted order.
The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of
labels j such that (i, j) is a directed edge of the graph.
*/
public class FindSafeState {
    public List<Integer> eventualSafeNodes(int[][] graph) {
    	List<List<Integer>> adjList = new ArrayList<>();
    	List<Integer> inDegZero = new ArrayList<>();
    	int[] indegree = new int[graph.length];
    	for(int i = 0; i < graph.length; i++) {
    		adjList.add(new ArrayList<>());
   			indegree[i] = graph[i].length;
   			if(indegree[i] == 0)
   				inDegZero.add(i); 
    	}
    	
    	for(int i = 0; i < graph.length; i++) {
    		for(int source : graph[i]) {
    			adjList.get(source).add(i);
    		}
    	}

    	while(!inDegZero.isEmpty()) {
    		Integer zero = inDegZero.remove(inDegZero.size() - 1);
    		for(Integer neighbor : adjList.get(zero)) {
    			indegree[neighbor]--;
    			if(indegree[neighbor] == 0)
    				inDegZero.add(neighbor);
    		}
    	}
    	
    	for(int i = 0; i < indegree.length; i++) {
    		if(indegree[i] == 0)
				inDegZero.add(i);
    	}
    	
    	return inDegZero;
    }
    
    public static void main(String[] s) {
    	FindSafeState safeState = new FindSafeState();
    	int[][] input = {{1,2},{2,3},{5},{0},{5},{},{}};
    	safeState.eventualSafeNodes(input);
    }

}
