package com.practice.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
Leetcode#310. Minimum Height Trees
For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. 
Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a 
function to find all the MHTs and return a list of their root labels. 
*/		
public class MinimumHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	List<Integer> leafs = new LinkedList<>();
    	if(n == 1) {
    		leafs.add(0);
    		return leafs;
    	}
    	
    	Map<Integer, Set<Integer>> graph = new HashMap<>();
    	int[] degree = new int[n];
    	for(int[] edge : edges ) {
    		graph.putIfAbsent(edge[0], new HashSet<>());
    		graph.get(edge[0]).add(edge[1]);
    		
    		graph.putIfAbsent(edge[1], new HashSet<>());
    		graph.get(edge[1]).add(edge[0]);
    		
    		degree[edge[0]]++;
    		degree[edge[1]]++;
    	}

    	for(int i = 0; i < n; i++) {
    		if(degree[i] == 1)
    			leafs.add(i);
    	}
    	
    	List<Integer> newLeafs = new LinkedList<>();
    	
		while (n > 2) {
			n = n - leafs.size();
			for (Integer leaf : leafs) {
				degree[leaf] = 0;
				for (Integer neighbor : graph.get(leaf)) {
					degree[neighbor]--;
					graph.get(neighbor).remove(leaf);
					if (degree[neighbor] == 1)
						newLeafs.add(neighbor);
				}
			}

			leafs = newLeafs;
			newLeafs = new LinkedList<>();
		}
    	
    	return leafs;
    }

    
    public static void main(String[] s) {
    	MinimumHeightTree mht = new MinimumHeightTree();
    	mht.findMinHeightTrees(4, new int[][]{{1,0},{1,2},{1,3}});
    }
}
