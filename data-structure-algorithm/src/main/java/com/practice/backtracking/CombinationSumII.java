package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Leetcode# 40. Combination Sum II
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates 
where the candidate numbers sums to target.
Each number in candidates may only be used once in the combination.
*/
public class CombinationSumII {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		allComb(result, new ArrayList<>(), candidates, target, 0, 0);
		return result;
    }
	
	private void allComb(List<List<Integer>> res, List<Integer> curr, int[] candidates, int target, int sum, int index) {
		if(sum > target)
			return;
		
		if(sum == target) {
			System.out.println(curr);
			res.add(new ArrayList<>(curr));
			return;
		}
		
		for(int i = index; i < candidates.length; i++) {
			if(i > index && candidates[i] == candidates[i - 1])
				continue;
			curr.add(candidates[i]);
			allComb(res, curr, candidates, target, sum + candidates[i], i + 1);
			curr.remove(curr.size() - 1);
		}
		
	}
	
	public static void main(String[] s) {
		CombinationSumII com = new CombinationSumII();
		com.combinationSum(new int[] {10,1,2,7,6,1,5}, 8);
	}

}
