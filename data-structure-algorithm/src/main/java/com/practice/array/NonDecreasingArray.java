package com.practice.array;
/*
Leetcode#665. Non-decreasing Array
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
*/
public class NonDecreasingArray {
	public boolean checkPossibility(int[] nums) {
		int len = nums.length;

		int i = 0;
		boolean used = false;
		while (i < len - 1) {
			if (nums[i] > nums[i + 1]) {
				if (used)
					return false;
				used = true;

				if (i < (len - 2)) {
					if (nums[i] <= nums[i + 2]) {
						i = i + 1;
					} else if (i > 0 && nums[i - 1] > nums[i + 1])
						return false;
				}
			}

			i = i + 1;
		}

		return true;
	}

}
