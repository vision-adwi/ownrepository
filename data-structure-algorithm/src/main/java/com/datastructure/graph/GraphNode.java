package com.datastructure.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.algorithm.graph.util.Colors;

public class GraphNode {
	private String name;
	private Map<GraphNode, Integer> neighbours;
	private boolean visited;
	private GraphNode parent;
	private Integer cost;
	public boolean cyclic;
	public Colors color;
	public int arrivaltime;
	public int departTime;

	public GraphNode(String theName) {
		name = theName;
		neighbours = new HashMap<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addNeighbour(GraphNode toNode) {
		addNeighbour(toNode, 0);
	}
	
	public void addNeighbour(GraphNode toNode, int weight) {
		neighbours.put(toNode, weight);
	}
	
	public Set<GraphNode> neighbours() {
		return neighbours.keySet();
	}

	public int getWeight(GraphNode toNode) {
		return neighbours.get(toNode);
	}
	
	public void visit() {
		visited = true;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void resetVisit() {
		visited = false;
	}
	
	public void setParent(GraphNode node) {
		parent = node;
	}
	
	public GraphNode getParent() {
		return parent;
	}
	
	public void setCost(int theCost) {
		this.cost = theCost;
	}
	
	public Integer getCost() {
		return this.cost;
	}

	@Override
	public boolean equals(Object object) {
		if (object == this)
			return true;

		if (object == null || (object.getClass() != this.getClass()))
			return false;

		GraphNode theNode = (GraphNode) object;

		return (name == theNode.getName() || (name != null && name
				.equals(theNode.getName())));
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public String toString() {
		return name;
	}

}
