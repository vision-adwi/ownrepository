package com.algorithm.graph;

import java.util.PriorityQueue;
import java.util.Stack;

import com.algorithm.graph.util.Util;
import com.datastructure.graph.AbstractGraph;
import com.datastructure.graph.GraphNode;

public class SSShortestPathDijkstra {
	AbstractGraph graph;
	
	public SSShortestPathDijkstra(AbstractGraph theGraph) {
		this.graph = theGraph;
	}

	public SSShortestPathDijkstra(AbstractGraph theGraph, int from) {
		this(theGraph);
		from(from);
	}

	public void from(int from) {
		Util.resetVertices(graph, false, true, true);
		if(!Util.validateInput(graph, from))
			return;

		dijkstra(from);
	}
	
	private void dijkstra(int from) {
		PriorityQueue<GraphNode> minHeap = new PriorityQueue<>(graph.vertices().size(),
													(t1, t2) -> t1.getCost().compareTo(t2.getCost()));
		for (int i = 0; i < graph.vertices().size(); i++) {
			GraphNode theNode = graph.vertices().get(i);
			theNode.setCost(i == (from - 1) ? 0 : Integer.MAX_VALUE);

			minHeap.offer(theNode);
		}
		
		GraphNode current = null;
		while ((current = minHeap.poll()) != null) {
			for (GraphNode neighbour : current.neighbors()) {
				int probableCost = current.getCost() +
						current.getWeight(neighbour);
				if (probableCost < neighbour.getCost()) {
					minHeap.remove(neighbour);

					neighbour.setCost(probableCost);
					neighbour.setParent(current);
					
					minHeap.offer(neighbour);
				}
			}
		}

	}
	
	public Stack<GraphNode> pathTo(int to) {
		GraphNode path = Util.getNode(graph, to);
		
		Stack<GraphNode> stack = new Stack<>();
		while (path != null) {
			stack.push(path);
			path = path.getParent();
		}

		return stack;
	}
	
	public int pathCost(int to) {
		GraphNode toNode = Util.getNode(graph, to);

		return toNode.getCost();
	}

}
