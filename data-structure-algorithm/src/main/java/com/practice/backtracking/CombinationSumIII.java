package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode# 216. Combination Sum III
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used 
and each combination should be a unique set of numbers.
*/
public class CombinationSumIII {
	public List<List<Integer>> combinationSum(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		allComb(result, new ArrayList<>(), k, n, 0, 1);
		return result;
    }
	
	private void allComb(List<List<Integer>> res, List<Integer> curr, int length, int target, int sum, int nextNumber) {
		if(length == curr.size()) {
			if(sum == target) {
				System.out.println(curr);
				res.add(new ArrayList<>(curr));
			}
			return;
		}
		
		if(sum > target)
			return;

		for(int i = nextNumber; i <= 9; i++) {
			curr.add(i);
			allComb(res, curr, length, target, sum + i, i + 1);
			curr.remove(curr.size() - 1);
		}	
	}
	
	public static void main(String[] s) {
		CombinationSumIII com = new CombinationSumIII();
		com.combinationSum(3, 9);
	}

}
