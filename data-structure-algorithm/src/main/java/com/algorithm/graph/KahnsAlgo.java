package com.algorithm.graph;

import java.util.ArrayList;
import java.util.List;
import com.datastructure.graph.AbstractGraph;
import com.datastructure.graph.GraphNode;

public class KahnsAlgo {
	AbstractGraph graph;
	
	public KahnsAlgo(AbstractGraph theGraph) {
		this.graph = theGraph;
	}
	
	public List<GraphNode> execute() {
		List<GraphNode> nodes = new ArrayList<>();
		for (GraphNode theNode : graph.vertices()) {
			if (theNode.indegree == 0)
				nodes.add(theNode);
		}

		List<GraphNode> sortedNodes = new ArrayList<>();
		while (!nodes.isEmpty()) {
			GraphNode current = nodes.remove(0);
			sortedNodes.add(current);
			for (GraphNode neighbour : current.neighbours()) {
				neighbour.indegree--;
				if (neighbour.indegree == 0) {
					nodes.add(neighbour);
				}
			}
		}

		return sortedNodes;
	}

}
