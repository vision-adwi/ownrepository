package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Leetcode#78. Subsets
Given a set of distinct integers, nums, return all possible subsets (the power set).
*/

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		find(res, new ArrayList<>(), nums, 0);
		return res;
    }
	
	private void find(List<List<Integer>> res, List<Integer> curr, int[] nums, int index) {
		if(index == nums.length) {
			System.out.println(curr);
			res.add(new ArrayList<>(curr));
			return;
		}
		
		curr.add(nums[index]);
		find(res, curr, nums, index + 1);
		curr.remove(curr.size() - 1);
		find(res, curr, nums, index + 1);
	}
	
	public static void main(String[] s) {
		Subsets sub = new Subsets();
		sub.subsets(new int[]{1, 2, 3});
	}

}
