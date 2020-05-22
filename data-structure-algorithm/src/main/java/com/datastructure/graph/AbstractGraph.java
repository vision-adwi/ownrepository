package com.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGraph implements Cloneable{
	protected List<GraphNode> adjacencyList;

	public AbstractGraph(int size) {
		adjacencyList = new ArrayList<>();
		initializeVertices(size);
	}

	public void initializeVertices(int size) {
		for (int i = 0; i < size; i++) {
			adjacencyList.add(new GraphNode("v" + (i + 1)));
		}
	}
	
	public List<GraphNode> vertices() {
		return adjacencyList;
	}

	public abstract void addEdge(int from, int to); 
	
	public abstract String graphName();
	
	public void addEdge(int from, int to, int weight) {
		addEdge(from, to);
	} 
	
	public void resetGraph() {
		for (GraphNode node : adjacencyList) {
			node.resetVisit();
		}
	}
	
	//Number of vertices
	public int v() {
		return this.adjacencyList.size();
	}
	
	//Number of edges
	public int e() {
		int count = 0;
		for (GraphNode vertex : adjacencyList) {
			count += vertex.neighbours().size();
		}

		return count;
	}
	
	public Iterable<GraphNode> adj(int vertex) {
		return adjacencyList.get(vertex - 1).neighbours();
	}
	
	@Override
	public String toString() {
		String info = graphName() + "\nVertices: " + v() + "\nEdges: " + e();
		return info;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
