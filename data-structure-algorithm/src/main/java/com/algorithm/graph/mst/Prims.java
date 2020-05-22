package com.algorithm.graph.mst;

import java.util.PriorityQueue;

import com.datastructure.graph.AbstractGraph;
import com.datastructure.graph.GraphNode;
/*
A minimum spanning tree(mst) is a subset of the edges of a connected, weighted, undirected graph that
- Connects all the vertices together.
- Without any cycles
- With minimum total edge weight.
 */
public class Prims {
	private AbstractGraph graph;
	
	public Prims(AbstractGraph theGraph) {
		this.graph = theGraph;
	}
	
	public void findMST() {
		PriorityQueue<GraphNode> queue = new PriorityQueue<GraphNode>(graph
				.vertices().size(), (p1, p2) -> p1.getCost().compareTo(p2.getCost()));
		for(int i = 1; i < graph.vertices().size(); i++) { 
			graph.vertices().get(i).setCost(Integer.MAX_VALUE);
		}
		graph.vertices().get(0).setCost(0);
		queue.offer(graph.vertices().get(0));
		
		GraphNode current = null;
		while((current = queue.poll()) != null) {
			for(GraphNode neighbour:current.neighbours()) {
				if(!neighbour.isVisited()) {
					int edgeWeight = current.getWeight(neighbour);
					if(edgeWeight < neighbour.getCost()) {
						neighbour.setCost(edgeWeight);
						queue.remove(neighbour); //It should be removed before inserting again.
						queue.offer(neighbour);
					}
				}
			}
			current.visit();
		}
	}

}
