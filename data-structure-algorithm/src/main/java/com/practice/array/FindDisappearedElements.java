package com.practice.array;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode#448. Find All Numbers Disappeared in an Array
Given an array of integers where 1 <= a[i] <= n (n = size of array), some elements appear twice and others appear once.
Find all the elements of [1, n] inclusive that do not appear in this array.
Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
*/
public class FindDisappearedElements {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums.length != 0) {
			for (int i = 0; i < nums.length; i++) {
				int n = Math.abs(nums[i]);
				nums[n - 1] = -Math.abs(nums[n - 1]);
			}

			for (int i = 0; i < nums.length; i++) {
				if (nums[i] > 0)
					result.add(i + 1);
			}
		}

		return result;
	}
}
