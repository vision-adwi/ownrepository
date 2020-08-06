package com.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
Leetcode#399. Evaluate Division
Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). 
Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].
*/
public class EvaluateDivision {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> weigtedDiGraph = new HashMap<>();
		
		for(int i = 0; i < equations.size(); i++) {	
			String source = equations.get(i).get(0);
			String destination = equations.get(i).get(1);
			
			weigtedDiGraph.putIfAbsent(source, new HashMap<>());
			weigtedDiGraph.get(source).put(destination, values[i]);

			weigtedDiGraph.putIfAbsent(destination, new HashMap<>());
			weigtedDiGraph.get(destination).put(source, 1 / values[i]);
		}
		
		double[] result = new double[queries.size()];
		for(int i = 0; i < queries.size(); i++) {
			List<String> query = queries.get(i);
			result[i] = dfs(weigtedDiGraph, query.get(0), query.get(1), 1.0, new HashSet<>());
		}
		
		return result;
    }
	
	private double dfs(Map<String, Map<String, Double>> graph, String source, String destination, double value,	Set<String> visited) {
		Map<String, Double> adjNode = graph.get(source);
		if (adjNode == null) {
			return -1.0;
		}

		visited.add(source);
		if (source.equals(destination))
			return value;

		for (String neighbor : adjNode.keySet()) {
			if (!visited.contains(neighbor)) {
				double res = dfs(graph, neighbor, destination, value * adjNode.get(neighbor), visited);
				if (Double.compare(res, -1.0) != 0)
					return res;
			}
		}

		return -1.0;
	}
	
	public static void main(String[] s) {
		EvaluateDivision eval = new EvaluateDivision();
		List<List<String>> equ = new ArrayList<>();
		equ.add(Arrays.asList("a", "b"));
		equ.add(Arrays.asList("b", "c"));
		List<List<String>> quer = new ArrayList<>();
		quer.add(Arrays.asList("b", "a"));
		eval.calcEquation(equ, new double[] {2.0,3.0}, quer);
		
	}

}
