package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode# 77. Combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
*/
public class Combination {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		allComb(result, new ArrayList<>(), n, k, 1);
		return result;
    }
	
	private void allComb(List<List<Integer>> res, List<Integer> curr, int range, int length, int nextNumber) {
		if(length == curr.size()) {
			System.out.println(curr);
			res.add(new ArrayList<>(curr));
			
			return;
		}

		for(int i = nextNumber; i <= range; i++) {
			curr.add(i);
			allComb(res, curr, range, length, i + 1);
			curr.remove(curr.size() - 1);
		}	
	}
	
	public static void main(String[] s) {
		Combination com = new Combination();
		com.combine(4, 3);
	}

}
