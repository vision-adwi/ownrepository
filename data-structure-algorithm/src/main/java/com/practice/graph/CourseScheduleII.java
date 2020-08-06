package com.practice.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
/*
Leetcode#210. Course Schedule II
There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
*/
public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		DirectedGraph graph = new DirectedGraph(numCourses);
		for(int row = 0; row < prerequisites.length; row++) {
			graph.addEdge(prerequisites[row][1], prerequisites[row][0]);
		}
		
		Stack<Integer> sortedOrder = new Stack<>();
		boolean[] visited = new boolean[numCourses];
		for(int i = 0; i < graph.adjList.size(); i++) {
			if(!visited[i])
				if(topologicalSort(graph.adjList.get(i), sortedOrder, visited, new boolean[numCourses]))
					return new int[] {};
		}

		int[] order = new int[sortedOrder.size()];//sortedOrder.stream().mapToInt(i -> i).toArray();
		int i = 0;
		while(!sortedOrder.isEmpty())
			order[i++] = sortedOrder.pop();

		return order;
	}
	
	private boolean topologicalSort(Node theNode, Stack<Integer> theStack, boolean[] visited, boolean[] cyclic) {
		if(cyclic[theNode.val])
			return true;
		
		if(visited[theNode.val])
			return false;
		
		visited[theNode.val] = true;
		
		cyclic[theNode.val] = true;
		for(Node neighbor : theNode.neighbors) {
			if(topologicalSort(neighbor, theStack, visited, cyclic)) {
				return true;
			}
		}
		cyclic[theNode.val] = false;
		theStack.push(theNode.val);
		
		return false;
	}
	
	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
		CourseScheduleII completion = new CourseScheduleII();
		completion.findOrder(numCourses, prerequisites);
	}
}

class DirectedGraph {
	List<Node> adjList;
	DirectedGraph() {
		adjList = new ArrayList<>();
	}
	
	DirectedGraph(int maxNodeValue) {
		adjList = new ArrayList<>();
		for(int i = 0; i < maxNodeValue; i++) {
			adjList.add(new Node(i));
		}
	}
	
	public void addEdge(int from, int to) {
		Node fromNode = adjList.get(from);
		Node toNode = adjList.get(to);
		
		fromNode.neighbors.add(toNode);
	}
}
