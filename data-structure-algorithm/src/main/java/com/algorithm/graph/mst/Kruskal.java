package com.algorithm.graph.mst;

import com.datastructure.disjointset.DisjointSet;
import com.datastructure.disjointset.UnionFind;
import com.datastructure.graph.AbstractGraph;
import com.datastructure.graph.GraphNode;

public class Kruskal {
	AbstractGraph graph;
	UnionFind sets;
	int mstCost;

	public Kruskal(AbstractGraph theGraph) {
		this.graph = theGraph;
		this.sets = new UnionFind(this.graph.vertices());
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
			for (GraphNode to : from.neighbors()) {
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
		DisjointSet fromSet = sets.find(from.getName());
		DisjointSet toSet = sets.find(to.getName());
		if (fromSet != toSet) { //Elements found in 2 different sets
			if (fromSet.size() > toSet.size()) {
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
