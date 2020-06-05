package com.algorithm.graph;

import java.util.Stack;

import com.algorithm.graph.util.Util;
import com.datastructure.graph.AbstractGraph;
import com.datastructure.graph.GraphNode;
import com.datastructure.queue.CircularQueue;

public class SSShortestPathBFS {
	AbstractGraph graph;

	public SSShortestPathBFS(AbstractGraph theGraph) {
		this.graph = theGraph;
	}

	public SSShortestPathBFS(AbstractGraph theGraph, int from) {
		this(theGraph);
		from(from);
	}
	
	public void from(int from) {
		Util.resetVertices(graph, true, true, false);
		GraphNode fromNode = Util.getNode(graph, from);
		if(fromNode == null)
			return;

		bfsNodes(fromNode, null);
	}
	
	public Stack<GraphNode> pathTo(int to) {
		GraphNode theNode = Util.getNode(graph, to);

		Stack<GraphNode> path = new Stack<>();
		while (theNode != null) {
			path.push(theNode);
			theNode = theNode.getParent();
		}

		return path;
	}

	public int pathHopsCount(int to) {
		GraphNode theNode = Util.getNode(graph, to);
		int i = -1;
		while (theNode != null) {
			theNode = theNode.getParent();
			i++;
		}

		return i;
	}
	
	public Stack<GraphNode> pathPair(int from, int to) {
		pathFromTo(from, to);
		return pathTo(to);
	}
	
	public int pathHopsCountPair(int from, int to) {
		pathFromTo(from, to);
		return pathHopsCount(to);
	}
	
	private void pathFromTo(int from, int to) {
		Util.resetVertices(graph, true, true, false);
		
		GraphNode fromNode = Util.getNode(graph, from);
		GraphNode toNode = Util.getNode(graph, to);
		if(fromNode == null || toNode == null)
			return;

		bfsNodes(fromNode, toNode);
	}

	private void bfsNodes(GraphNode fromNode, GraphNode toNode) {
		CircularQueue queue = new CircularQueue();
		fromNode.visit();
		queue.enqueue(fromNode);

		Object theNode;
		while ((theNode = queue.dequeue()) != null) {
			GraphNode currentVertex = (GraphNode) theNode;
			for (GraphNode neighbour : currentVertex.neighbours()) {
				if (!neighbour.isVisited()) {
					neighbour.setParent(currentVertex);
					neighbour.visit();
					queue.enqueue(neighbour);
					if(neighbour == toNode)
						return;
				}
			}
		}
	}
}
