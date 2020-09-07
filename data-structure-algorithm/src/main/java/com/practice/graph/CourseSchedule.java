package com.practice.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
Leetcode#207. Course Schedule
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
*/
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		int[] indegree = new int[numCourses];
		
		for(int i = 0; i < numCourses; i++)
			graph.put(i, new HashSet<>());
			
		for(int[] edge : prerequisites) {
			graph.get(edge[1]).add(edge[0]);
			indegree[edge[0]]++;
		}

		List<Integer> noInDegree = new LinkedList<>();
		for(int i = 0; i < numCourses; i++) {
			if(indegree[i] == 0)
				noInDegree.add(i);
		}
		
		List<Integer> next = new LinkedList<>();	
		while (!noInDegree.isEmpty()) {
			numCourses = numCourses - noInDegree.size();
			for (Integer node : noInDegree) {
				for (Integer neighbor : graph.get(node)) {
					indegree[neighbor]--;

					if (indegree[neighbor] == 0) {
						next.add(neighbor);
					}
				}
				graph.remove(node);
			}

			noInDegree = next;
			next = new LinkedList<>();
		}
		
		return (numCourses == 0);
	}

	public boolean canFinish_(int numCourses, int[][] prerequisites) {
		DirectedGraph graph = new DirectedGraph(numCourses);
		for(int row = 0; row < prerequisites.length; row++) {
			graph.addEdge(prerequisites[row][1], prerequisites[row][0]);
		}
		
		boolean[] visited = new boolean[numCourses];
		for(int i = 0; i < graph.adjList.size(); i++) {
			if(!visited[i])
				if(isCyclic(graph.adjList.get(i), visited, new boolean[numCourses]))
					return false;
		}
		
		return true;
	}

	private boolean isCyclic(Node theNode, boolean[] visited, boolean[] cyclic) {
		if(cyclic[theNode.val])
			return true;
		
		if(visited[theNode.val])
			return false;
		
		visited[theNode.val] = true;
		
		cyclic[theNode.val] = true;
		for(Node neighbor : theNode.neighbors) {
			if(isCyclic(neighbor, visited, cyclic)) {
				return true;
			}
		}
		cyclic[theNode.val] = false;
		
		return false;
	}
	
	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
		CourseSchedule completion = new CourseSchedule();
		System.out.println(completion.canFinish(2, new int[][]{}));
	}
}

