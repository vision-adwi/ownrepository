package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Leetcode# 46. Permutations
Given a collection of distinct integers, return all possible permutations.
*/		
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums.length > 0)
			find(res, nums, new ArrayList<>(), new boolean[nums.length]);

		return res;
    }
	
	private void find(List<List<Integer>> res, int[] nums, List<Integer> curr, boolean[] visited) {
		if(curr.size() == nums.length) {
			System.out.println(curr);
			res.add(new ArrayList<>(curr));
			return;
		}

		for(int i = 0; i < nums.length; i++) {
			if(visited[i])
				continue;

			curr.add(nums[i]); visited[i] = true;
			find(res, nums, curr, visited);
			curr.remove(curr.size() - 1); visited[i] = false;
		}
	}
	
	public static void main(String[] s) {
		Permutations perm = new Permutations();
		perm.permute(new int[]{3, 1, 2});
	}

}
