package com.algorithm.graph.util;

import java.util.Stack;

import com.datastructure.graph.AbstractGraph;
import com.datastructure.graph.DirectedGraph;
import com.datastructure.graph.GraphNode;

public class DFSUtil {
	public static void traversal(AbstractGraph graph) {
		for (GraphNode vertex : graph.vertices()) {
			if (!vertex.isVisited()) {
				traverse(vertex, true);
			}
		}
		System.out.println();
	}

	private static void traverse(GraphNode vertex, boolean print) {
		vertex.visit();
		if(print)
			System.out.print(vertex + "  ");
		
		for (GraphNode neighbour : vertex.neighbors()) {
			if (!neighbour.isVisited()) {
				traverse(neighbour, print);
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

		for (GraphNode neighbour : vertex.neighbors()) {
			if (!neighbour.isVisited()) {
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
		if (vertex.cyclic)
			return true;

		if (vertex.isVisited())
			return false;

		vertex.visit();
		vertex.cyclic = true;
		for (GraphNode neighbour : vertex.neighbors()) {
			if (isCyclicDirected(neighbour)) {
				return true;
			}
		}
		vertex.cyclic = false;
		
		return false;
	}
	
	private static boolean isCyclicUndirected(GraphNode vertex, GraphNode parent) {
		vertex.visit();

		for (GraphNode neighbour : vertex.neighbors()) {
			if (!neighbour.isVisited()) {
				if (isCyclicUndirected(neighbour, vertex))
					return true;
			} else if (neighbour != parent) {
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
		GraphNode sourceNode = Util.getNode(graph, from);
		GraphNode destinationNode = Util.getNode(graph, to);
		
		return countPaths(sourceNode, destinationNode, 0);
	}
	
	private static int countPaths(GraphNode current, GraphNode destination, int count) {
		if (current == destination) {
			count++;
		} else {
			for (GraphNode neighbour : current.neighbors()) {
				count = countPaths(neighbour, destination, count);
			}
		}
		return count;
	}
	
	public static int[][] transitiveClosure(AbstractGraph graph) {
		int size = graph.v();
		int[][] trans = new int[size][size];

		for (int fromIdx = 0; fromIdx < size; fromIdx++) {
			GraphNode fromNode = graph.vertices().get(fromIdx);
			for (GraphNode toNode : fromNode.neighbors()) {
				int toIdx = Util.parse(toNode.getName());
				trans[fromIdx][toIdx] = 1;
			}

		}

		return trans;
	}

	
	public static AbstractGraph transpose(AbstractGraph graph) {
		int size = graph.v();
		AbstractGraph transposeGraph = new DirectedGraph(size);

		for(int fromIdx = 0; fromIdx < size; fromIdx++) {
			GraphNode fromNode = graph.vertices().get(fromIdx);
			for (GraphNode toNode : fromNode.neighbors()) {
				int toIdx = Util.parse(toNode.getName());
				transposeGraph.addEdge(toIdx + 1 , fromIdx + 1);
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
	
	public static void kColorable(AbstractGraph graph) {
		Colors[] colors = new Colors[]{Colors.BLACK, Colors.RED, Colors.GREEN};
		kColorableNodes(graph, 0, colors);
	}
	
	private static void kColorableNodes(AbstractGraph graph, int index,	Colors[] colors) {
		//terminal condition(base condition)
		if (index == graph.v()) {
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
	
	private static boolean colorable(GraphNode vertex, Colors color) {
		for (GraphNode neighbour : vertex.neighbors()) {
			if (neighbour.color == color) {
				return false;
			}
		}
		return true;
	}
	
	public static int connectedComponents(AbstractGraph graph) {
		AbstractGraph trGraph = DFSUtil.transpose(graph);
		Stack<GraphNode> stack = DFSUtil.topologicalSort(graph);
		
		int count = 0;
		while(!stack.isEmpty()) {
			int idx = Util.parse(stack.pop().getName());
			GraphNode pushedNode = trGraph.vertices().get(idx);
			if(!pushedNode.isVisited()) {
				traverse(pushedNode, true);
				System.out.println(); count++;
			}
		}
		
		return count;
	}
	
	public static boolean isStronglyConnectedGraph(AbstractGraph graph) {
		AbstractGraph trGraph = DFSUtil.transpose(graph);
		Stack<GraphNode> stack = DFSUtil.topologicalSort(graph);
		
		boolean traversedAll = false;
		while(!stack.isEmpty()) {
			int idx = Util.parse(stack.pop().getName());
			GraphNode pushedNode = trGraph.vertices().get(idx);
			if(!pushedNode.isVisited()) {
				if(traversedAll)
					return false;
				traverse(pushedNode, false);
				traversedAll = true;
			}
		}
		
		return true;
	}
	
	private static void topologicalOrder(GraphNode vertex, Stack<GraphNode> stack) {
		vertex.visit();
		for(GraphNode neighbour:vertex.neighbors()) {
			if(!neighbour.isVisited()) {
				topologicalOrder(neighbour, stack);
			}
		}
		
		stack.push(vertex);
	}
}
