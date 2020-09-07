package com.practice.graph;
/*
Leetcode#1306. Jump Game III
Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, 
you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
Notice that you can not jump outside of the array at any time.
*/
public class JumpGameIII {
	public boolean canReach(int[] arr, int start) {
		boolean[] visited = new boolean[arr.length];
        return traverse(arr, start, visited);
    }
	
	private boolean traverse(int[] arr, int next, boolean[] visited) {
		if(next >= arr.length || next < 0 || visited[next])
			return false;
		
		if(arr[next] == 0)
			return true;
		
		visited[next] = true;
		boolean flag = traverse(arr, next + arr[next], visited);
		if(!flag)
			flag = traverse(arr, next - arr[next], visited);
		
		return flag;
	}
}
