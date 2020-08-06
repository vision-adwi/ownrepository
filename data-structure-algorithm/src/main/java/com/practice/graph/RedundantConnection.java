package com.practice.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
/*
Leetcode#684. Redundant Connection
In this problem, a tree is an undirected graph that is connected and has no cycles.
The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), 
with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, 
that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple 
answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v. 
*/		
public class RedundantConnection {
	Map<Integer, Set<Integer>> disjointSet = new HashMap<>();
	public int[] findRedundantConnection(int[][] edges) {
		for(int[] edge : edges) {
			Integer source_vertex = find(edge[0]);
			Integer target_vertex = find(edge[1]);
			
			if(source_vertex == null) {
				source_vertex = create(edge[0]);
			}
			if(target_vertex == null) {
				target_vertex = create(edge[1]);
			}
			if(target_vertex == source_vertex) {
				return edge;
			}
			
			union(source_vertex, target_vertex);
		}
		return null;
	}
	
	private Integer create(Integer element) {
		Set<Integer> set = new HashSet<>();
		set.add(element);
		
		disjointSet.put(element, set);
		return element;
	}
	
	private Integer find(Integer element) {
		for(Integer leader : disjointSet.keySet()) {
			if(disjointSet.get(leader).contains(element))
				return leader;
		}
		
		return null;
	}
	
	private void union(Integer leader1, Integer leader2) {
		if(disjointSet.get(leader1).size() > disjointSet.get(leader2).size()) {
			for(Integer element : disjointSet.get(leader2)) {
				disjointSet.get(leader1).add(element);
			}
			disjointSet.remove(leader2);
		}
		else {
			for(Integer element : disjointSet.get(leader1)) {
				disjointSet.get(leader2).add(element);
			}
			disjointSet.remove(leader1);
		}
	}

	public static void main(String[] s) {
		int[][] edges = {{1,2}, {1,3}, {2,3}};
		RedundantConnection connection = new RedundantConnection();
		IntStream.of(connection.findRedundantConnection(edges)).forEach(System.out::print);
	}

}
