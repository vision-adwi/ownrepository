package com.algorithm.graph.util;

import java.util.Stack;

import com.datastructure.graph.AbstractGraph;
import com.datastructure.graph.DirectedGraph;
import com.datastructure.graph.GraphNode;

public class DFSUtil {
	public static void traversal(AbstractGraph graph) {
		for (GraphNode vertex : graph.vertices()) {
			if (!vertex.isVisited()) {
				traverse(vertex);
			}
		}
		System.out.println("");
	}

	private static void traverse(GraphNode vertex) {
		vertex.visit();
		System.out.print(vertex + "  ");
		
		for (GraphNode neighbour : vertex.neighbours()) {
			if (!neighbour.isVisited()) {
				traverse(neighbour);
			}
		}
	}
	
	public static void inOutTimeOfVertices(AbstractGraph graph) {
		Integer timeCount = 0;
		for (GraphNode vertex : graph.vertices()) {
			if (!vertex.isVisited()) {
				timeCount = inOutTime(vertex, timeCount);
			}
		}

	}
	
	private static Integer inOutTime(GraphNode vertex, Integer timeCount) {
		vertex.visit();
		vertex.arrivaltime = timeCount++;
		
		for(GraphNode neighbour:vertex.neighbours()) {
			if(!neighbour.isVisited()) {
				timeCount = inOutTime(neighbour, timeCount);
			}
		}
		vertex.departTime = timeCount++;
		return timeCount;
	}
	
	public static boolean isCyclic(AbstractGraph graph) {
		boolean isUndirected = graph.graphName().contains("Undirected");
		if (isUndirected) {
			for (GraphNode node : graph.vertices()) {
				if (!node.isVisited() && isCyclicUndirected(node, null))
					return true;
			}
		} else {
			for (GraphNode node : graph.vertices()) {
				if (isCyclicDirected(node))
					return true;
			}
		}

		return false;
	}
	
	private static boolean isCyclicDirected(GraphNode vertex) {
		if (vertex.isCyclic)
			return true;

		if (vertex.isVisited())
			return false;

		vertex.visit();
		vertex.isCyclic = true;
		for (GraphNode neighbour : vertex.neighbours()) {
			if (isCyclicDirected(neighbour)) {
				return true;
			}
		}
		vertex.isCyclic = false;
		return false;
	}
	
	private static boolean isCyclicUndirected(GraphNode vertex, GraphNode parent) {
		vertex.visit();

		for (GraphNode neighbour : vertex.neighbours()) {
			if (!neighbour.isVisited()) {
				if(isCyclicUndirected(neighbour, vertex))
					return true;
			}
			else if(neighbour != parent) {
				return true;
			}
		}
		return false;
	}
	
	public static int totalPaths(AbstractGraph graph, int from, int to) {
		if(isCyclic(graph)) {
			System.out.println("Graph is cyclic, so path can not be counted.");
			return Integer.MAX_VALUE;
		}
		GraphNode fromNode = graph.vertices().get(from - 1);
		GraphNode toNode = graph.vertices().get(to - 1);
		
		return countPaths(fromNode, toNode, 0);
	}
	
	private static int countPaths(GraphNode current, GraphNode destination,	int count) {
		if (current == destination) {
			count++;
		} else {
			for (GraphNode neighbour : current.neighbours()) {
				count = countPaths(neighbour, destination, count);
			}
		}
		return count;
	}
	
	public static int[][] transitiveClosure(AbstractGraph graph) {
		int size = graph.vertices().size();
		int[][] trans = new int[size][size];
		
		for(GraphNode node:graph.vertices()) {
			tranClosure(node, node, trans);
		}
		return trans;
	}
	
	private static void tranClosure(GraphNode from, GraphNode to, int[][] trans) {
		trans[parse(from.getName())][parse(to.getName())] = 1;

		for (GraphNode adjacent : to.neighbours()) {
			if (trans[parse(from.getName())][parse(adjacent.getName())] == 0) {
				tranClosure(from, adjacent, trans);
			}
		}
	}
	
	public static AbstractGraph transpose(AbstractGraph graph) {
		AbstractGraph transposeGraph = new DirectedGraph(graph.vertices().size());

		for (GraphNode fromNode : graph.vertices()) {
			GraphNode trToNode = transposeGraph.vertices().get(parse(fromNode.getName()));
			for (GraphNode toNode : fromNode.neighbours()) {
				GraphNode trFromNode = transposeGraph.vertices().get(parse(toNode.getName()));
				trFromNode.addNeighbour(trToNode);
			}
		}
		
		return transposeGraph;
	}
	
	public static Stack<GraphNode> topologicalSort(AbstractGraph graph) {
		Stack<GraphNode> stack = new Stack<>();
		for(GraphNode vertex:graph.vertices()) {
			if(!vertex.isVisited()) {
				topologicalOrder(vertex, stack);
			}
		}
		
		return stack;
	}
	
	private static void topologicalOrder(GraphNode vertex, Stack<GraphNode> stack) {
		for(GraphNode neighbour:vertex.neighbours()) {
			if(!neighbour.isVisited()) {
				topologicalOrder(neighbour, stack);
			}
		}
		
		stack.push(vertex);
		vertex.visit();
	}
	
	public static void kColorable(AbstractGraph graph) {
		Colors[] colors = new Colors[]{Colors.BLACK, Colors.RED, Colors.GREEN};
		kColorableNodes(graph, 0, colors);
	}
	
	private static void kColorableNodes(AbstractGraph graph, int index,	Colors[] colors) {
		//terminal condition(base condition)
		if (index == graph.vertices().size()) {
			for (GraphNode vertex : graph.vertices()) {
				System.out.print(vertex + "(" + vertex.color + ")  ");
			}
			System.out.println();

			return;
		}
		
		GraphNode current = graph.vertices().get(index);
		for (Colors color : colors) {
			if(colorable(current, color)) {
				current.color = color;
				kColorableNodes(graph, index + 1, colors);
				//backtrack
				current.color = null;
			}

		}
	}
	
	
	
	private static int parse(String nodeName) {
		return Integer.parseInt(nodeName.substring(1)) - 1;
	}
	
	private static boolean colorable(GraphNode vertex, Colors color) {
		for (GraphNode neighbour : vertex.neighbours()) {
			if (neighbour.color == color) {
				return false;
			}
		}
		return true;
	}

}
