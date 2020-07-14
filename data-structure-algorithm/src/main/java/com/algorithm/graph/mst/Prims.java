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
		PriorityQueue<GraphNode> minHeap = new PriorityQueue<>(graph.vertices().size(),
													(t1, t2) -> t1.getCost().compareTo(t2.getCost()));
		for(int i = 1; i < graph.vertices().size(); i++) { 
			graph.vertices().get(i).setCost(Integer.MAX_VALUE);
		}
		graph.vertices().get(0).setCost(0);
		minHeap.offer(graph.vertices().get(0));
		
		GraphNode current = null;
		while((current = minHeap.poll()) != null) {
			for(GraphNode neighbour:current.neighbors()) {
				if(!neighbour.isVisited()) {
					int edgeWeight = current.getWeight(neighbour);
					if(edgeWeight < neighbour.getCost()) {
						neighbour.setCost(edgeWeight);
						minHeap.remove(neighbour); //It should be removed before inserting again.
						minHeap.offer(neighbour);
					}
				}
			}
			current.visit();
		}
	}

}
