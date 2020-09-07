package com.practice.array;

import java.util.stream.IntStream;

/*
Leetcode#724. Find Pivot Index
Given an array of integers nums, write a method that returns the "pivot" index of this array.
We define the pivot index as the index where the sum of all the numbers to the left of the index is equal to the sum of all the numbers to the right of the index.
If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
*/
public class PivotIndex {
    public int pivotIndex(int[] nums) {
		if (nums.length == 0)
			return -1;

		int sum = IntStream.of(nums).sum();

		int left_sum = 0;
		for(int i = 0; i < nums.length; i++) {
			if ((2 * left_sum) == (sum - nums[i]))
				return i;

			left_sum += nums[i];
		}
		return -1;
    }

    public static void main(String[] s) {
    	PivotIndex pivot = new PivotIndex();
    	System.out.println(pivot.pivotIndex(new int[] {-1,-1,0,1,1,0}));
    }
}
