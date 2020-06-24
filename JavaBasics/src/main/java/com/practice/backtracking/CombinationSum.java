package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		allComb(result, new ArrayList<>(), candidates, target, 0, 0);
		return result;
    }
	
	private void allComb(List<List<Integer>> res, List<Integer> curr, int[] candidates, int target, int sum, int index) {
		if(sum > target)
			return;
		
		if(sum == target) {
			res.add(new ArrayList<>(curr));
			return;
		}
		
		for(int i = index; i < candidates.length; i++) {
			curr.add(candidates[i]);
			allComb(res, curr, candidates, target, sum + candidates[i], i);
			curr.remove(curr.size() - 1);
		}
		
	}
	
	public static void main(String[] s) {
		CombinationSum com = new CombinationSum();
		com.combinationSum(new int[] {2, 3, 6, 7}, 7);
	}

}
