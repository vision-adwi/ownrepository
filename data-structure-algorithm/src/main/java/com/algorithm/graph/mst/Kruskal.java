package com.algorithm.graph.mst;

import com.datastructure.disjointset.DisjointSet;
import com.datastructure.disjointset.DisjointSets;
import com.datastructure.graph.AbstractGraph;
import com.datastructure.graph.GraphNode;

public class Kruskal {
	AbstractGraph graph;
	DisjointSets sets;
	int mstCost;

	public Kruskal(AbstractGraph theGraph) {
		this.graph = theGraph;
		this.sets = new DisjointSets(this.graph.vertices());
	}

	public int mst() {
		int nextMinEdgeCost = 0;
		while (sets.size() > 1) {
			nextMinEdgeCost = minimumSpanningTree(nextMinEdgeCost);
		}
		
		return mstCost;
	}
	private int minimumSpanningTree(int minEdge) {
		int nextMinEdge = Integer.MAX_VALUE;
		for (GraphNode from : graph.vertices()) {
			for (GraphNode to : from.neighbours()) {
				int edgeWeight = from.getWeight(to);
				if (edgeWeight == minEdge) {
					if(joinSets(from, to))
						mstCost = mstCost + minEdge;
					continue;
				}

				if (edgeWeight > minEdge && edgeWeight < nextMinEdge) {
					nextMinEdge = edgeWeight;
				}
			}
		}

		return nextMinEdge;
	}
	
	private boolean joinSets(GraphNode from, GraphNode to) {
		DisjointSet fromSet = sets.findSet(from.getName());
		DisjointSet toSet = sets.findSet(to.getName());
		if (fromSet != toSet) { //Elements found in 2 different sets
			if (fromSet.getSize() > toSet.getSize()) {
				sets.union(fromSet, toSet);
			} else {
				sets.union(toSet, fromSet);
			}
			return true;
		}
		else {
			return false;
		}
	}
}
