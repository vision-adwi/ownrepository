package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Leetcode# 47. Permutations II
Given a collection of numbers that might contain duplicates, return all possible unique permutations.
*/		
public class PermutationsUnique {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums.length <= 0)
			return res;
		
		Arrays.sort(nums);
		find(res, nums, new ArrayList<>(), new boolean[nums.length]);
        
		return res;
    }
	
	private void find(List<List<Integer>> res, int[] nums, List<Integer> curr, boolean[] visited) {
		if(curr.size() == nums.length) {
			res.add(new ArrayList<>(curr));
			return;
		}

		for(int i = 0; i < nums.length; i++) {
			if(visited[i])
				continue;
			
			if((i > 0) && nums[i] == nums[i - 1] && !visited[i - 1])
				continue;
			
			curr.add(nums[i]); visited[i] = true;
			find(res, nums, curr, visited);
			curr.remove(curr.size() - 1); visited[i] = false;
		}
	}

}
