package com.datastructure.graph;


public class UndirectedGraph extends AbstractGraph{
	
	public UndirectedGraph(int size) {
		super(size);
	}
	
	public void addEdge(int from, int to) {
		GraphNode fromNode = adjacencyList.get(from - 1);
		GraphNode toNode = adjacencyList.get(to - 1);

		fromNode.addNeighbour(toNode);
		toNode.addNeighbour(fromNode);
	}

	@Override
	public String graphName() {
		return "Unweighted Undirected graph";
	}

}
