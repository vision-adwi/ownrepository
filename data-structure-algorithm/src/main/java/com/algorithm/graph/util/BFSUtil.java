package com.algorithm.graph.util;

import java.util.ArrayDeque;
import java.util.Queue;

import com.datastructure.graph.AbstractGraph;
import com.datastructure.graph.GraphNode;

public class BFSUtil {
	//Traversal by recursion
	public static void traversal(AbstractGraph graph) {
		Queue<GraphNode> queue = new ArrayDeque<>();
		for (GraphNode vertex : graph.vertices()) {
			if (!vertex.isVisited()) {
				vertex.visit();
				queue.offer(vertex);
				traverse(queue);
			}
		}
		System.out.println();
	}
	
	private static void traverse(Queue<GraphNode> queue) {
		if (!queue.isEmpty()) {
			GraphNode vertex = queue.poll();
			System.out.print(vertex + "  ");
			for (GraphNode neighbour : vertex.neighbors()) {
				if (!neighbour.isVisited()) {
					neighbour.visit();
					queue.offer(neighbour);
				}
			}
			traverse(queue);
		}
	}
	
	public static void shortestPathSS(AbstractGraph graph, int source) {
		Queue<GraphNode> queue = new ArrayDeque<>();
		GraphNode sourceNode = Util.getNode(graph, source);
		sourceNode.visit();
		queue.add(sourceNode);
		shortestPath(queue, null);
	}
	
	public static void shortestPathPair(AbstractGraph graph, int source, int destination) {
		Queue<GraphNode> queue = new ArrayDeque<>();
		
		GraphNode sourceNode = Util.getNode(graph, source);
		GraphNode destNode = Util.getNode(graph, destination);
		
		if(sourceNode == null || destNode == null)
			return;
		
		sourceNode.visit();
		queue.add(sourceNode);
		shortestPath(queue, destNode);
	}
	
	public static int minEdgeCount(AbstractGraph graph, int source, int destination) {
		GraphNode destNode = Util.getNode(graph, destination);
		if(destNode == null)
			return 0;
		
		shortestPathPair(graph, source, destination);
		
		int count = 0;
		GraphNode parent = destNode.getParent();
		while(parent != null) {
			count++;
			parent = parent.getParent();
		}
		
		return count;
	}
	
	private static void shortestPath(Queue<GraphNode> queue, GraphNode destination) {
		if (!queue.isEmpty()) {
			GraphNode vertex = queue.poll();
			for (GraphNode neighbour : vertex.neighbors()) {
				if (!neighbour.isVisited()) {
					neighbour.setParent(vertex);
					neighbour.visit();
					if(neighbour == destination) {//Abort if destination node is found
						return;
					}
					queue.add(neighbour);
				}
			}
			
			shortestPath(queue, destination);
		}
	}
}
