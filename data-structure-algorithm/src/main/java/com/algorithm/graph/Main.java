package com.algorithm.graph;

import java.util.List;
import java.util.Stack;

import com.algorithm.graph.mst.Kruskal;
import com.algorithm.graph.mst.Prims;
import com.algorithm.graph.util.BFSUtil;
import com.algorithm.graph.util.DFSUtil;
import com.algorithm.graph.util.Util;
import com.datastructure.graph.AbstractGraph;
import com.datastructure.graph.GraphNode;

/*
- Vertices
- Edges
- Unweighted graph
- Weighted graph
- Undirected graph
- Directed graph
- Cyclic graph
- Acyclic graph
- Disconnected graph
- Tree - is a specialized type of directed acyclic graph(DAG)
*/
public class Main {

	public static void main(String[] args) {
		//traversal();
		//transpose();
		//topologicalSort();
		//singleSourceShortestPath();
		//allSourceShortestPath();
		//minSpanningTree();
		//totalPaths();
		//transitiveClosure();
		//kColorableTest();
		//arrDepTimeForVertex();
		//dfsAllSourceSPath();
		//dijkstraSSSPath();
		//dijkstraAllSSPath();
		kosarajuAlgorithm();
		//stronglyConnectedGraph();
	
	}

	private static void traversal() {
		//undirectedGraphTraversal();
		directedGraphTraversal();
	}
	
	private static void undirectedGraphTraversal() {
		AbstractGraph graph = Util.createUndirectedGraph();

		BFSUtil.traversal(graph);
		Util.resetVertices(graph, true, false, false);
		DFSUtil.traversal(graph);
	}
	
	private static void directedGraphTraversal() {
		AbstractGraph graph = Util.createDirectedGraph();

		BFSUtil.traversal(graph);
		Util.resetVertices(graph, true, false, false);
		DFSUtil.traversal(graph);
	}
	
	private static void transpose() {
		AbstractGraph graph = Util.createDirectedGraph();
		AbstractGraph traGraph = DFSUtil.transpose(graph);
		
		DFSUtil.traversal(graph);
		DFSUtil.traversal(traGraph);
	}
	
	private static void topologicalSort() {
		AbstractGraph graph = Util.createDirectedGraph();
		System.out.println(graph);

		Stack<GraphNode> sortedNodes = DFSUtil.topologicalSort(graph);
		Util.printStack(sortedNodes, false);
	}
	
	private static void singleSourceShortestPath() {
		dfsSSSPath();
	}
	
	private static void allSourceShortestPath() {
		dijkstraAllSSPath();
	}
	
	private static void minSpanningTree() {
		//kruskalTest();
		primsTest();
	}
	
	
	private static void topologicalSortKahns() {
		AbstractGraph graph = Util.createDirectedGraph();
		System.out.println(graph);

		KahnsAlgo kAlgo = new KahnsAlgo(graph);
		List<GraphNode> sortedNodes = kAlgo.execute();
		for(GraphNode node:sortedNodes) {
			System.out.print(node.getName() + " ");
		}
	}
	
	private static void totalPaths() {
		AbstractGraph graph = Util.unweighted_directed_graph2();
		System.out.print("DFS Traversal:");
		DFSUtil.traversal(graph);
		System.out.println("Total number of paths V1 -> V5 : " + DFSUtil.totalPaths(graph, 1, 5));
		System.out.println("Total number of paths V1 -> V4 : " + DFSUtil.totalPaths(graph, 1, 4));
		System.out.println("Total number of paths V4 -> V5 : " + DFSUtil.totalPaths(graph, 4, 5));
		System.out.println("Total number of paths V5 -> V4 : " + DFSUtil.totalPaths(graph, 5, 4));
		System.out.println("Total number of paths V1 -> V3 : " + DFSUtil.totalPaths(graph, 1, 3));
		System.out.println("Is graph cyclic : " + DFSUtil.isCyclic(graph));
	}
	
	private static void cyclicGraphDetetection() {
		AbstractGraph graph = Util.unweighted_directed_graph3();
		System.out.print("DFS Traversal:");
		DFSUtil.traversal(graph);
		System.out.println("Is graph cyclic : " + DFSUtil.isCyclic(graph));
		System.out.println("Total number of paths V1 -> V4 : " + DFSUtil.totalPaths(graph, 1, 4));
	}
	
	private static void transitiveClosure() {
		AbstractGraph graph = Util.unweighted_directed_graph3();
		int[][] trans = DFSUtil.transitiveClosure(graph);
		
		for(int i = 0; i < graph.vertices().size(); i++) {
			for(int j = 0; j < graph.vertices().size(); j++) {
				System.out.print(trans[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	private static void kColorableTest() {
		AbstractGraph graph = Util.unweighted_undirected_graph2();
		DFSUtil.kColorable(graph);
	}
	
	private static void arrDepTimeForVertex() {
		AbstractGraph graph = Util.unweighted_undirected_graph2();
		DFSUtil.inOutTimeOfVertices(graph);
		
		for(GraphNode vertex:graph.vertices()) {
			System.out.println(vertex + "(" + vertex.arrivaltime + ", " + vertex.departTime + ")");
		}
	}
	
	private static void kruskalTest() {
		AbstractGraph graph = Util.createWeightedUndirectedGraph();
		System.out.println(graph);
		
		Kruskal kruskalAlgorithm = new Kruskal(graph);
		System.out.println(kruskalAlgorithm.mst());
	}
	
	private static void primsTest() {
		AbstractGraph graph = Util.createWeightedUndirectedGraph();
		
		Prims primsAlgorithm = new Prims(graph);
		primsAlgorithm.findMST();
		int total = 0;
		for (GraphNode vertex : graph.vertices()) {
			System.out.println(vertex + " -> " + vertex.getCost());
			total = total + vertex.getCost();
		}
		System.out.println("Minimum spanning tree value : " + total);
		
	}
	
	private static void dfsSSSPath() {
		AbstractGraph graph = Util.createUndirectedGraph();
		
		SSShortestPathBFS bfsShortestPath = new SSShortestPathBFS(graph);
		bfsShortestPath.from(10);
		Stack<GraphNode> path = bfsShortestPath.pathTo(8);
		Util.printStack(path, false);
		System.out.println();
		System.out.println(bfsShortestPath.pathHopsCount(8));
	}
	
	private static void dfsAllSourceSPath() {
		AbstractGraph graph = Util.createUndirectedGraph();
		SSShortestPathBFS bfsShortestPath = new SSShortestPathBFS(graph);

		for(int from = 0; from < graph.v(); from++) {
			bfsShortestPath.from(from + 1);
			for(int to = 0; to < graph.v(); to++) {
				System.out.print(bfsShortestPath.pathHopsCount(to + 1) + " ");
			}
			System.out.println();
		}


	}
	
	private static void dijkstraSSSPath() {
		AbstractGraph graph = Util.createWeightedUndirectedGraph();
		System.out.println(graph);

		SSShortestPathDijkstra dijkstraShortestPath = new SSShortestPathDijkstra(graph, 1);

		Stack<GraphNode> pathStack = dijkstraShortestPath.pathTo(6);
		Util.printStack(pathStack, true);
	}
	
	private static void dijkstraAllSSPath() {
		AbstractGraph graph = Util.createWeightedUndirectedGraph();
		System.out.println(graph);
		
		AllSourceShortestPathDijkstra allSortPathDijkstra = new AllSourceShortestPathDijkstra(graph);
		
		Stack<GraphNode> pathStack = allSortPathDijkstra.pathPair(2, 4);
		Util.printStack(pathStack, false);
		System.out.println(":" + allSortPathDijkstra.pathPairCost(2, 4));
		
		pathStack = allSortPathDijkstra.pathPair(2, 8);
		Util.printStack(pathStack, false);
		System.out.println(":" + allSortPathDijkstra.pathPairCost(2, 8));
		
		pathStack = allSortPathDijkstra.pathPair(1, 9);
		Util.printStack(pathStack, false);
		System.out.println(":" + allSortPathDijkstra.pathPairCost(1, 9));
		
		pathStack = allSortPathDijkstra.pathPair(3, 6);
		Util.printStack(pathStack, false);
		System.out.println(":" + allSortPathDijkstra.pathPairCost(3, 6));
		


	}
	
	private static void kosarajuAlgorithm() {
		AbstractGraph graph = Util.unweighted_directed_graph4();

		int connectedCmpCount = DFSUtil.connectedComponents(graph);
		System.out.println("Total connected components - " + connectedCmpCount);
	}
	
	private static void stronglyConnectedGraph() {
		AbstractGraph graph = Util.unweighted_directed_graph4();

		System.out.println(graph + "\nStrongly connected graph - " + DFSUtil.isStronglyConnectedGraph(graph));
	}

}
