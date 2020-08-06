package com.practice.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelay {
	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, Map<Integer, Integer>> weigtedDiGraph = new HashMap<>();

		for (int i = 0; i < times.length; i++) {
			Integer source = times[i][0];

			weigtedDiGraph.putIfAbsent(source, new HashMap<>());
			weigtedDiGraph.get(source).put(times[i][1], times[i][2]);
		}

		Integer[][] costMap = new Integer[N][2];
		PriorityQueue<Integer[]> minHeap = new PriorityQueue<Integer[]>((e1, e2) -> e1[1].compareTo(e2[1]));
		for (int i = 1; i <= N; i++) {
			costMap[i - 1][0] = i;
			costMap[i - 1][1] = (i == K) ? 0 : Integer.MAX_VALUE;
		}
		minHeap.offer(costMap[K - 1]);

		int maxCost = 0;
		boolean[] visited = new boolean[N];
		while (!minHeap.isEmpty()) {
			Integer[] vertex = minHeap.poll();
			visited[vertex[0] - 1] = true;
			maxCost = Math.max(maxCost, vertex[1]);

			Map<Integer, Integer> neighbors = weigtedDiGraph.get(vertex[0]);
			if (neighbors != null) {
				for (Integer key : neighbors.keySet()) {
					if (!visited[key - 1] && costMap[key - 1][1] > neighbors.get(key) + vertex[1]) {
						minHeap.remove(costMap[key - 1]);
						costMap[key - 1][1] = neighbors.get(key) + vertex[1];
						minHeap.offer(costMap[key - 1]);
					}
				}
			}
		}
		
		for(boolean allVisited : visited) {
			if(!allVisited)
				return -1;
		}
		
		return maxCost;
	}

}
