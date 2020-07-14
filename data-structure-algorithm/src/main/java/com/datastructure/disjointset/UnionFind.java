package com.datastructure.disjointset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.datastructure.graph.GraphNode;

public class UnionFind {
	Map<String, DisjointSet> disjointSets = new HashMap<>();

	public UnionFind(List<GraphNode> nodes) {
		for (GraphNode node : nodes) {
			DisjointSet element = new DisjointSet(node.getName());
			disjointSets.put(node.getName(), element);
		}
	}

	public void union(DisjointSet target, DisjointSet source) {
		for (String member : source.getMembers()) {
			target.addMember(member);
		}
		disjointSets.remove(source.getId());
	}

	public DisjointSet find(String ele) {
		for(DisjointSet set : disjointSets.values()) {
			if(set.containMember(ele))
				return set;
		}

		return null;
	}
	
	public int size() {
		return disjointSets.size();
	}
}
