package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Leetcode#90. Subsets II
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
*/

public class SubsetsDuplicate {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		find(res, new ArrayList<>(), nums, 0);
		return res;
    }
	
	private void find(List<List<Integer>> res, List<Integer> curr, int[] nums, int index) {
		if(index == nums.length) {
			res.add(new ArrayList<>(curr));
			return;
		}
		
		curr.add(nums[index]);
		find(res, curr, nums, index + 1);
		curr.remove(curr.size() - 1);
		
		while(index + 1 < nums.length && nums[index] == nums[index + 1])
			index++;
		find(res, curr, nums, index + 1);
	}
	
	public static void main(String[] s) {
		SubsetsDuplicate sub = new SubsetsDuplicate();
		sub.subsetsWithDup(new int[]{1, 2, 2});
	}

}
