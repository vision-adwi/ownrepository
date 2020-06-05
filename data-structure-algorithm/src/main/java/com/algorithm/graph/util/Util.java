package com.algorithm.graph.util;

import java.util.Stack;

import com.datastructure.graph.AbstractGraph;
import com.datastructure.graph.DirectedGraph;
import com.datastructure.graph.GraphNode;
import com.datastructure.graph.UndirectedGraph;
import com.datastructure.graph.WeightedUndirectedGraph;

public class Util {

	public static AbstractGraph createUndirectedGraph() {
		AbstractGraph graph = new UndirectedGraph(10);
	
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		//graph.setPath(3, 7);
		graph.addEdge(3, 9);
		graph.addEdge(4, 5);
		graph.addEdge(6, 7);
		graph.addEdge(7, 8);
		//graph.setPath(7, 9);
		graph.addEdge(9, 10);
	
		return graph;
	}

	public static AbstractGraph createDirectedGraph() {
		AbstractGraph graph = new DirectedGraph(10);
	
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		graph.addEdge(3, 7);
		graph.addEdge(3, 9);
		graph.addEdge(4, 5);
		graph.addEdge(6, 7);
		graph.addEdge(7, 8);
		graph.addEdge(7, 9);
		graph.addEdge(9, 10);
	
		return graph;
	}

	public static AbstractGraph createWeightedUndirectedGraph() {
		AbstractGraph graph = new WeightedUndirectedGraph(8);
	
		graph.addEdge(1, 2, 5);
		graph.addEdge(2, 3, 7);
		graph.addEdge(2, 4, 25);
		graph.addEdge(2, 5, 20);
		graph.addEdge(3, 7, 10);
		graph.addEdge(4, 5, 4);
		graph.addEdge(5, 6, 25);
		graph.addEdge(6, 8, 10);
		graph.addEdge(7, 8, 15);
	
		return graph;
	}
	
	public static AbstractGraph unweighted_directed_graph2() {
		AbstractGraph graph = new DirectedGraph(5);
	
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 5);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(3, 5);
		graph.addEdge(4, 3);

		return graph;
	}
	
	public static AbstractGraph unweighted_directed_graph3() {
		AbstractGraph graph = new DirectedGraph(4);
	
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(3, 1);
		graph.addEdge(4, 4);

		return graph;
	}
	
	public static AbstractGraph unweighted_undirected_graph2() {
		AbstractGraph graph = new UndirectedGraph(6);
	
		graph.addEdge(1, 2);
		graph.addEdge(1, 5);
		graph.addEdge(1, 6);
		graph.addEdge(2, 5);
		graph.addEdge(2, 4);
		graph.addEdge(5, 3);
		graph.addEdge(6, 5);
		graph.addEdge(3, 4);

		return graph;
	}

	public static void printStack(Stack<GraphNode> pathStack, boolean costFlag) {
		boolean flag = false;
		GraphNode node = null;
		while (pathStack != null && !pathStack.isEmpty()) {
			System.out.print(flag ? "->" : "");
			System.out.print(node = pathStack.pop());
			flag = true;
		}
		if (costFlag) {
			System.out.print(":" + node.getCost());
		}
	}
	
	public static boolean validateInput(AbstractGraph graph, int value) {
		if (value < 1 || value > graph.vertices().size()) {
			System.out.println("Index value is out of scope...!!!");
			return false;
		}
		else {
			return true;
		}

	}
	
	public static GraphNode getNode(AbstractGraph graph, int value) {
		if (value < 1 || value > graph.vertices().size())  {
			System.out.println("Index value is out of scope...!!!");
			return null;
		}
		else {
			return graph.vertices().get(value - 1);
		}

	}
	
	public static void resetVertices(AbstractGraph graph, boolean visit, boolean parent, boolean cost) {
		for (GraphNode node : graph.vertices()) {
			if(visit)
				node.resetVisit();
			
			if(parent)
				node.setParent(null);
			
			if(cost)
				node.setCost(0);
			
		}
	}

}
