package com.algorithm.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.datastructure.graph.AbstractGraph;
import com.datastructure.graph.GraphNode;

public class AllSourceShortestPathDijkstra {
	int size;
	int[][] costMatrix;
	List<List<Stack<GraphNode>>> allPaths;

	SSShortestPathDijkstra ssShortestPathDijkstra;

	public AllSourceShortestPathDijkstra(AbstractGraph theGraph) {
		ssShortestPathDijkstra = new SSShortestPathDijkstra(theGraph);
		size = theGraph.v();
		costMatrix = new int[size][size];
		allPaths = new ArrayList<>();
		
		execute();
	}
	
	private void execute() {
		for (int from = 0; from < size; from++) {
			ssShortestPathDijkstra.from(from + 1); // This line will fetch the single source shortest path
			List<Stack<GraphNode>> paths = new ArrayList<>();
			for (int to = 0; to < size; to++) {
				Stack<GraphNode> path = ssShortestPathDijkstra.pathTo(to + 1);
				paths.add(path);

				costMatrix[from][to] = ssShortestPathDijkstra.pathCost(to + 1);
			}
			allPaths.add(paths);
		}
	}
	
	public int pathPairCost(int from, int to) {
		if(from >= size || to >= size) {
			return 0;
		}
		else {
			return costMatrix[from - 1][to - 1];
		}
	}
	
	public Stack<GraphNode> pathPair(int from, int to) {
		if(from >= size || to >= size) {
			return null;
		}
		else {
			return allPaths.get(from - 1).get(to - 1);
		}
	}
}
