package com.practice.unionfind;

import java.util.HashSet;
import java.util.Set;

public class DisjointSet {
	Integer id;
	Set<Integer> sets = new HashSet<>();
	
	public DisjointSet(Integer id) {
		this.id = id;
		add(id);
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public boolean contains(Integer element) {
		return sets.contains(element);
	}
	
	public void add(Integer element) {
		sets.add(element);
	}
	
	public Set<Integer> elements() {
		return sets;
	}
	
	public int size() {
		return sets.size();
	}

}
