package com.practice.array;

/*
Leetcode#565. Array Nesting
A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, 
where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

Suppose the first element in S starts with the selection of element A[i] of index = i, the next element 
in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.
*/
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
    	int maxCount = Integer.MIN_VALUE;
    	boolean[] visited = new boolean[nums.length];
    	for(int i = 0; i < nums.length; i++) {
    		int count = 0;
    		int k = i;
    		while(!visited[k]) {
    			visited[k] = true;
    			k = nums[k];
    			count++;
    		}
    		
    		maxCount = Math.max(count, maxCount);
    	}
    	
    	return maxCount;
    }

}
