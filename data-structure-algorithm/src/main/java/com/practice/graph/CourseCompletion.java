package com.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class CourseCompletion {

	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
		/*int numCourses = 2;
		int[][] prerequisites = { { 1, 0 } };*/
		DiUnweightedGraph graph = new DiUnweightedGraph(numCourses);
		for (int row = 0; row < prerequisites.length; row++) {
			int from = prerequisites[row][1];
			int to = prerequisites[row][0];
			graph.setPath(from, to);
		}

		boolean cyclic = false;
		for (GraphNode vertex : graph.vertices()) {
			if(!vertex.isVisited())
				if(isCyclic(vertex)) {
					cyclic = true;
					break;
				}
		}
		graph.resetVisit();
		Stack<GraphNode> stack = new Stack<>();
		for (GraphNode vertex: graph.vertices()) {
			if(!vertex.isVisited()) {
				topologicalSort(vertex, stack);
			}
		}
		
		if (!cyclic) {
			for (int i = 0; i < numCourses; i++) {
				System.out.print(stack.pop().getValue() + " ");
			}
		}
	}
	
	private static void topologicalSort(GraphNode theNode, Stack<GraphNode> stack) {
		for(GraphNode vertex:theNode.neighbours()) {
			if(!vertex.isVisited()) {
				topologicalSort(vertex, stack);
			}
		}

		stack.push(theNode);
		theNode.visit();
	}
	
	private static boolean isCyclic(GraphNode theNode) {
		if(theNode.cyclic)
			return true;
		if(theNode.isVisited())
			return false;
		
		theNode.cyclic = true;
		theNode.visit();
		for(GraphNode vertex:theNode.neighbours()) {
			if(isCyclic(vertex)) {
				return true;
			}
		}
		theNode.cyclic = false;
		return false;
	}

}

class DiUnweightedGraph {
	List<GraphNode> adjacencyList;
	public DiUnweightedGraph(int numbers) {
		adjacencyList = new ArrayList<>();
		for(int vertex = 0; vertex < numbers; vertex++) {
			adjacencyList.add(new GraphNode(vertex));
		}
	}
	
	public void setPath(int from, int to) {
		GraphNode fromNode = adjacencyList.get(from);
		GraphNode toNode = adjacencyList.get(to);
		
		fromNode.add(toNode);
	}
	
	public List<GraphNode> vertices() {
		return adjacencyList;
	}
	
	public void resetVisit() {
		for(GraphNode vertex:adjacencyList) {
			vertex.resetVisit();
		}
	}
	
}

class GraphNode {
	Integer value;
	Map<GraphNode, Integer> neighbours;
	boolean visited;
	boolean cyclic;
	
	public GraphNode(int theValue) {
		value = theValue;
		neighbours = new HashMap<>();
	}
	
	public Integer getValue() {
		return value;
	}
	
	public Set<GraphNode> neighbours() {
		return neighbours.keySet();
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void visit() {
		visited = true;
	}
	
	public void resetVisit() {
		visited = false;
	}
	
	public void add(GraphNode theNode) {
		add(theNode, 0);
	}
	
	public void add(GraphNode theNode, Integer weight) {
		neighbours.put(theNode, weight);
	}
}

