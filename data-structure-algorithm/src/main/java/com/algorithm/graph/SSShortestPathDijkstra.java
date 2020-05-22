package com.algorithm.graph;

import java.util.PriorityQueue;
import java.util.Stack;

import com.datastructure.graph.AbstractGraph;
import com.datastructure.graph.GraphNode;

public class SSShortestPathDijkstra {
	AbstractGraph graph;

	public SSShortestPathDijkstra(AbstractGraph theGraph, int from) {
		this.graph = theGraph;
		if (from < 1 || from > graph.vertices().size()) {
			System.out.println("Please provide a valid vertex number...");
		}
		else {
			shortestPathFrom(from);
		}
	}

	private void shortestPathFrom(int from) {
		PriorityQueue<GraphNode> minHeap = new PriorityQueue<>(graph.vertices().size(),
				(t1, t2) -> t1.getCost().compareTo(t2.getCost()));

		for (int i = 0; i < graph.vertices().size(); i++) {
			GraphNode theNode = graph.vertices().get(i);
			if (i != (from - 1))
				theNode.setCost(Integer.MAX_VALUE);
			else
				theNode.setCost(0);

			minHeap.offer(theNode);
		}
		
		dijkstra(minHeap);
	}
	
	private void dijkstra(PriorityQueue<GraphNode> minHeap) {
		GraphNode theNode = null;

		while ((theNode = minHeap.poll()) != null) {
			for (GraphNode neighbour : theNode.neighbours()) {
				int edgeWeight = theNode.getWeight(neighbour);
				if (neighbour.getCost() > (theNode.getCost() + edgeWeight)) {
					minHeap.remove(neighbour);

					neighbour.setCost(theNode.getCost() + edgeWeight);
					neighbour.setParent(theNode);
					
					minHeap.offer(neighbour);
				}
			}

		}

	}
	
	public Stack<GraphNode> shortestPathTo(int to) {
		if (to < 1 || to > graph.vertices().size()) {
			System.out.println("Please provide a valid vertex number...");
			return null;
		}

		Stack<GraphNode> stack = new Stack<>();

		GraphNode path = graph.vertices().get(to - 1);
		while (path != null) {
			stack.push(path);
			path = path.getParent();
		}

		return stack;
	}

}
