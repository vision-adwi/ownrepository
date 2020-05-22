package com.algorithm.graph;

import com.datastructure.graph.AbstractGraph;
import com.datastructure.graph.GraphNode;
import com.datastructure.queue.CircularQueue;

public class SSShortestPathBFS {
	AbstractGraph graph;

	public SSShortestPathBFS(AbstractGraph theGraph) {
		this(theGraph, 0);
	}

	public SSShortestPathBFS(AbstractGraph theGraph, int from) {
		this.graph = theGraph;
		if (from != 0) {
			shortestPathFrom(from);
		}
	}

	public void shortestPathFrom(int from) {
		if (from < 1 || from > graph.vertices().size()) {
			System.out.println("Please provide correct vertex number...");
			return;
		}
		GraphNode fromNode = graph.vertices().get(from - 1);
		bfsNodes(fromNode);
	}

	private void bfsNodes(GraphNode node) {
		CircularQueue queue = new CircularQueue();
		node.visit();
		queue.enqueue(node);

		Object theNode;
		while ((theNode = queue.dequeue()) != null) {
			GraphNode currentVertex = (GraphNode) theNode;
			for (GraphNode neighbour : currentVertex.neighbours()) {
				if (!neighbour.isVisited()) {
					neighbour.setParent(currentVertex);
					neighbour.visit();
					queue.enqueue(neighbour);
				}
			}
		}
	}

	public int shortestPathTo(int to) {
		if (to < 1 || to > graph.vertices().size()) {
			System.out.println("Please provide correct vertex number...");
			return -1;
		}

		GraphNode toNode = graph.vertices().get(to - 1);

		GraphNode parentNode = toNode;
		int i = -1;
		while (parentNode != null) {
			System.out.print(parentNode + " ");
			parentNode = parentNode.getParent();
			i++;
		}

		return i;
	}

}
