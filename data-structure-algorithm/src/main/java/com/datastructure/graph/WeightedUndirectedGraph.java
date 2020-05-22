package com.datastructure.graph;


public class WeightedUndirectedGraph extends UndirectedGraph {
	public WeightedUndirectedGraph(int size) {
		super(size);
	}
	
	@Override
	public void addEdge(int from, int to, int weight) {
		GraphNode fromNode = adjacencyList.get(from - 1);
		GraphNode toNode = adjacencyList.get(to - 1);

		fromNode.addNeighbour(toNode, weight);
		toNode.addNeighbour(fromNode, weight);
	}
	
	@Override
	public void addEdge(int from, int to) {
		this.addEdge(from, to, 1);
	}
	
	@Override
	public String graphName() {
		return "Weighted Undirected graph";
	}

}
