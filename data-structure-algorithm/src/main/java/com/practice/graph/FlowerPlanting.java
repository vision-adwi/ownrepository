package com.practice.graph;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode#1042. Flower Planting With No Adjacent
You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.
paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.
Also, there is no garden that has more than 3 paths coming into or leaving it.
Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.

Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.  
The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.
*/
public class FlowerPlanting {
    public int[] gardenNoAdj(int N, int[][] paths) {
    	List<List<Integer>> graph = new ArrayList<>();
    	for(int i = 0; i < N; i++) {
    		graph.add(new ArrayList<>());
    	}
    	
    	for(int[] path : paths) {
    		graph.get(path[0] - 1).add(path[1]);
    		graph.get(path[1] - 1).add(path[0]);
    	}
    	
    	int[] plantations = new int[N];
    	plantAFlower(graph, 0, plantations);
    	
        return plantations;
    }
    
    private boolean plantAFlower(List<List<Integer>> graph, int index, int[] plant) {
    	if(index >= graph.size())
    		return true;
    	    	
    	List<Integer> node = graph.get(index);
    	for(int i = 1; i <= 4; i++) {
    		if(feasible(node, i, plant)) {
    			plant[index] = i;
    			if(plantAFlower(graph, index + 1, plant))
    				return true;
    			plant[index] = 0;
    		}
    	}
    	
    	return false;
    }
    
    private boolean feasible(List<Integer> node, Integer option, int[] plant) {
    	for(Integer adj : node) {
    		if(plant[adj - 1] == option) {
    			return false;
    		}
    	}
    	
    	return true;
    }

}
