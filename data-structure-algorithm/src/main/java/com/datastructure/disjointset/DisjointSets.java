package com.datastructure.disjointset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.datastructure.graph.GraphNode;

public class DisjointSets {
	Map<String, DisjointSet> disjointSets = new HashMap<>();

	public DisjointSets(List<GraphNode> nodes) {
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

	public DisjointSet findSet(String ele) {
		for (Entry<String, DisjointSet> entries : disjointSets.entrySet()) {
			if (entries.getValue().containMember(ele)) {
				return entries.getValue();
			}
		}

		return null;
	}
	
	public int size() {
		return disjointSets.size();
	}
}
