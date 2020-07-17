package com.practice.array;

import java.util.HashSet;
import java.util.Set;
/*
Leetcode#565. Array Nesting
A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, 
where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

Suppose the first element in S starts with the selection of element A[i] of index = i, the next element 
in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.
*/
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
    	boolean[] visited = new boolean[nums.length];
    	
    	int max = 0;
    	Set<Integer> set;
    	for(int i = 0; i < nums.length; i++) {
    		if(visited[i])
    			continue;
    		
    		set = new HashSet<>();
    		int index = i;
    		while(!set.contains(index)) {
    			visited[index] = true;
    			set.add(index);
    			index = nums[index];
    		}
    		if(set.size() > max)
    			max = set.size();
    	}
    	
    	return max;
        
    }
    
    public int arrayNesting1(int[] nums) {
    	int max = 0;
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i] < 0)
    			continue;

    		int index = i, count = 0;
    		while(nums[index] >= 0) {
    			++count;
    			int tmp = nums[index];
    			if(nums[index] == 0)
    				nums[index] = -150000000;
    			else
    				nums[index] = -nums[index];
    			
    			index = tmp;	
    		}
    		
    		if(count > max)
    			max = count;
    	}
    	
    	return max;
        
    }

}
