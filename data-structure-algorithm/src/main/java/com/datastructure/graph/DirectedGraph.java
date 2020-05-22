package com.datastructure.graph;


public class DirectedGraph extends AbstractGraph{
	
	public DirectedGraph(int size) {
		super(size);
	}
	
	@Override
	public void addEdge(int from, int to) {
		GraphNode fromNode = adjacencyList.get(from - 1);
		GraphNode toNode = adjacencyList.get(to - 1);

		fromNode.addNeighbour(toNode);
	}

	@Override
	public String graphName() {
		return "Unweighted Directed graph";
	}

}