package com.datastructure.graph;


public class WeightedDirectedGraph extends UndirectedGraph {
	public WeightedDirectedGraph(int size) {
		super(size);
	}
	
	@Override
	public void addEdge(int from, int to, int weight) {
		GraphNode fromNode = adjacencyList.get(from - 1);
		GraphNode toNode = adjacencyList.get(to - 1);

		fromNode.addNeighbour(toNode, weight);
	}
	
	@Override
	public void addEdge(int from, int to) {
		this.addEdge(from, to, 1);
	}
	
	@Override
	public String graphName() {
		return "Weighted Directed graph";
	}

}
