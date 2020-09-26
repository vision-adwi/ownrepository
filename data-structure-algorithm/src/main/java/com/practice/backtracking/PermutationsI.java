package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode# 46. Permutations
Given a collection of distinct integers, return all possible permutations.
*/		
public class PermutationsI {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums.length > 0) {
		    find(res, nums, new ArrayList<>(), new boolean[nums.length]);
        }
        
		return res;
    }
	
	private void find(List<List<Integer>> res, int[] nums, List<Integer> curr, boolean[] visited) 
    {
		if(curr.size() == nums.length) {
			res.add(new ArrayList<>(curr));
			return;
		}

		for(int i = 0; i < nums.length; i++) {
			if(!visited[i]) {
                curr.add(nums[i]); visited[i] = true;
                find(res, nums, curr, visited);
                curr.remove(curr.size() - 1); visited[i] = false;
            }
		}
	}
	
	public static void main(String[] s) {
		PermutationsI perm = new PermutationsI();
		System.out.println(perm.permute(new int[]{1, 3, 2}));
	}

}
