package com.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Leetcode#886. Possible Bipartition
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
Each person may dislike some other people, and they should not go into the same group. 
Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
Return true if and only if it is possible to split everyone into two groups in this way.
*/
public class PossibleBipartition {
	public boolean possibleBipartition(int N, int[][] dislikes) {
		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < dislikes.length; i++) {
			Integer source = dislikes[i][0];
			Integer target = dislikes[i][1];
			graph.get(source - 1).add(target - 1);
			graph.get(target - 1).add(source - 1);
		}
		
		boolean[] visited = new boolean[N];
		char[] colors = new char[N];
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				colors[i] = 'R';
				visited[i] = true;
				queue.offer(i);
				if(!dfs(graph, queue, colors, visited))
					return false;
			}
		}
        
		return true;
    }
	
	private boolean dfs(List<List<Integer>> graph, Queue<Integer> queue, char[] colors, boolean[] visited) {
		while(!queue.isEmpty()) {
			Integer vertex = queue.poll();
			char shade = colors[vertex] == 'R' ? 'B' : 'R';
			List<Integer> neighbors = graph.get(vertex);
			if(neighbors != null) {
				for(Integer neighbor : neighbors) {
					if(!visited[neighbor]) {
						colors[neighbor] = shade;
						visited[neighbor] = true;
						queue.offer(neighbor);
						dfs(graph, queue, colors, visited);
					}
					else {
						if(colors[vertex] == colors[neighbor])
							return false;
					}
				}
				
			}
		}
		
		return true;
	}
}
