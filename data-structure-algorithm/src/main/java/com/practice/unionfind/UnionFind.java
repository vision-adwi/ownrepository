package com.practice.unionfind;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {
	Map<Integer, DisjointSet> disjointSets = new HashMap<>();
	
	public UnionFind(int size) {
		for(int i = 0; i < size; i++) {
			disjointSets.put(i, new DisjointSet(i));
		}
	}
	
	public DisjointSet find(int element) {
		for(DisjointSet set : disjointSets.values()) {
			if(set.contains(element))
				return set;
		}
		
		return null;
	}
	
	public void union(DisjointSet from, DisjointSet to) {
		if(from != to) {
			if(from.size() > to.size()) {
				merge(from, to);
			}
			else {
				merge(to, from);
			}
		}
	}
	
	private void merge(DisjointSet destination, DisjointSet source) {
		for(Integer element : source.elements()) {
			destination.add(element);
		}
		
		disjointSets.remove(source.getId());
	}

	public int size() {
		return disjointSets.size();
	}
}
