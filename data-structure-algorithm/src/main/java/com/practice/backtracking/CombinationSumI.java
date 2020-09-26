package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode# 39. Combination Sum I
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.
*/
public class CombinationSumI {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		allComb(result, new ArrayList<>(), candidates, target, 0);
		return result;
    }
	
	private void allComb(List<List<Integer>> res, List<Integer> curr, int[] candidates, int target, int index) {
		if(target < 0)
			return;
		
		if(target == 0) {
			System.out.println(curr);
			res.add(new ArrayList<>(curr));
			return;
		}
		
		for(int i = index; i < candidates.length; i++) {
			curr.add(candidates[i]);
			allComb(res, curr, candidates, target - candidates[i], i);
			curr.remove(curr.size() - 1);
		}	
	}
	
	public static void main(String[] s) {
		CombinationSumI com = new CombinationSumI();
		com.combinationSum(new int[] {1,2,3,6,7}, 7);
	}

}
