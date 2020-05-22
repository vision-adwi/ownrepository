package com.algorithm.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import com.datastructure.graph.AbstractGraph;
import com.datastructure.graph.GraphNode;

public class AllSourceShortestPathDijkstra {
	AbstractGraph graph;
	Map<Integer, AbstractGraph> sourceMap = new HashMap<>();

	public AllSourceShortestPathDijkstra(AbstractGraph theGraph) throws CloneNotSupportedException {
		this.graph = theGraph;
		for(int i = 1; i <= graph.vertices().size(); i++ ) {
			AbstractGraph newGraph = (AbstractGraph)graph.clone();
			sourceMap.put(i, newGraph);
			
			shortestPathFrom(newGraph, i);
		}
		
	}

	private void shortestPathFrom(AbstractGraph clonedGraph, int from) {
		PriorityQueue<GraphNode> minHeap = new PriorityQueue<>(clonedGraph
				.vertices().size(), (t1, t2) -> t1.getCost().compareTo(t2.getCost()));

		for (int i = 0; i < clonedGraph.vertices().size(); i++) {
			GraphNode theNode = clonedGraph.vertices().get(i);
			if (i == (from - 1))
				theNode.setCost(0);
			else
				theNode.setCost(Integer.MAX_VALUE);

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
	
	public Stack<GraphNode> shortestPathPair(int from, int to) {
		if (from < 1 || from > graph.vertices().size() || to < 1 || to > graph.vertices().size()) {
			System.out.println("Please provide a valid vertex number...");
			return null;
		}

		AbstractGraph fromMap = sourceMap.get(from);
		Stack<GraphNode> stack = new Stack<>();

		GraphNode path = fromMap.vertices().get(to - 1);
		while (path != null) {
			stack.push(path);
			path = path.getParent();
		}

		return stack;
	}

}
