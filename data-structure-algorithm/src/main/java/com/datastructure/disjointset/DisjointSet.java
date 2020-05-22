package com.datastructure.disjointset;

import java.util.HashSet;
import java.util.Set;

public class DisjointSet {
	private final String id;
	private Set<String> members = new HashSet<>();
	
	public DisjointSet(String theId) {
		this.id = theId;
		addMember(theId);
	}
	
	public void addMember(String member) {
		members.add(member);
	}
	
	public boolean containMember(String member) {
		return members.contains(member);
	}
	
	public Set<String> getMembers() {
		return this.members;
	}
	
	public String getId() {
		return this.id;
	}
	
	public int getSize() {
		return members.size();
	}
	
	/*@Override
	public boolean equals(Object obj) {
		DisjointSet element = (DisjointSet)obj;
		
		return element.getId().equals(this.getId());
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}*/
	
	@Override
	public String toString() {
		String str = this.getId() + "{ ";
		for(String member:members) {
			str = str + member + " ";
		}
		str = str + " }";
		
		return str;
	}

}
