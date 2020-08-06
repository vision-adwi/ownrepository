package com.practice.diviceandconquer;
/*
Leetcode#53. Maximum Subarray
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
*/		
public class MaxSubArray {
	public int maxSubArray_bruteforce(int[] nums) {
		int max = 0;
        for(int i = 0; i < nums.length; i++) {
        	int sum = 0;
        	for(int j = i; j < nums.length; j++) {
        		sum = sum + nums[j];
        		max = Math.max(max, sum);
        	}
        }
        return max;
    }
	
	//Kadane's algo
	public int maxSubArray(int[] nums) {
		if(nums.length == 0)
			return 0;
		
		int max = nums[0];
		int current_sum = nums[0];
		for(int i = 1; i < nums.length; i++) {
			current_sum = Math.max(current_sum + nums[i], nums[i]);
			max = Math.max(current_sum, max);
		}
		
		return max;
	}
	
	public static void main(String[] s) {
		int[] input = {-2,1,-3,4,-1,2,1,-5,4};
		MaxSubArray subArray = new MaxSubArray();
		System.out.println(subArray.maxSubArray_bruteforce(input));
		System.out.println(subArray.maxSubArray(input));
	}

}
