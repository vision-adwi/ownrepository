package com.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/*
Leetcode#785. Is Graph Bipartite?
Given an undirected graph, return true if and only if it is bipartite.
Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B 
such that every edge in the graph has one node in A and another node in B.
The graph is given in the following form: graph[i] is a list of indexes j for which the edge between 
nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
*/
public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
    	List<List<Integer>> adjList = new ArrayList<>();
    	for(int i = 0; i < graph.length; i++) {
    		adjList.add(IntStream.of(graph[i]).boxed()
    				.collect(Collectors.toList()));
    	}
    	
    	boolean[] visited = new boolean[graph.length];
    	char[] color = new char[graph.length];
    	
    	Queue<Integer> queue = new LinkedList<>();
    	for(int i = 0; i < adjList.size(); i++) {
    		if(!visited[i]) {
    	    	visited[i] = true;
    	    	color[i] = 'R';
    	    	queue.offer(i);
    	    	
    	    	if(!bfs(queue, color, visited, adjList))
    	    		return false;
    		}
    	}
    	
    	return true;        
    }
    
    private boolean bfs(Queue<Integer> queue, char[] color, boolean[] visited, List<List<Integer>> adjList) {
    	while(!queue.isEmpty()) {
    		Integer vertex = queue.poll();
    		char shade = color[vertex] == 'R' ? 'B' : 'R';
    		for(Integer neighbor : adjList.get(vertex)) {
    			if(!visited[neighbor]) {
    				color[neighbor] = shade;
    				visited[neighbor] = true;
    				queue.offer(neighbor);
    			}
    			else {
    				if(color[vertex] == color[neighbor])
    					return false;
    			}
    		}
    		
    	}

    	return true;
    }
    
    public static void main(String[] s) {
    	BipartiteGraph graph = new BipartiteGraph();
    	
    	int[][] input = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
    	graph.isBipartite(input);
    }

}
