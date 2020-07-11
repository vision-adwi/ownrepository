package com.practice.diviceandconquer;
/*
Leetcode#53. Maximum Subarray
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
*/		
public class MaxSubArray {
	public int subarray(int[] arr, int start, int end, int sum) {
		if(end == arr.length)
			return sum;
		
		sum = sum + arr[end];
		int cal1 = subarray(arr, start, end + 1, sum);
		int cal2 = subarray(arr, start + 1, end + 1, sum - arr[start]);
		
		return Math.max(cal1, cal2);
	}
	
	public int maxSubArray_bruteforce(int[] nums) {
		int max = 0;
        for(int i = 0; i < nums.length; i ++) {
        	int sum = 0;
        	for(int j = i; j < nums.length; j++) {
        		sum = sum + nums[j];
        		if (sum > max) 
        			max = sum;
        	}
        }
        return max;
    }
	
	//Kadane's algo
	public int maxSubArray(int[] nums) {
		if(nums.length == 0)
			return 0;
		
		int max = nums[0];
		int current_max = nums[0];
		for(int i = 1; i < nums.length; i++) {
			current_max = Math.max(current_max + nums[i], nums[i]);
			if(current_max > max)
				max = current_max;
		}
		
		return max;
	}
	
	public static void main(String[] s) {
		int[] input = {-2,1,-3,4,-1,2,1,-5,4};
		MaxSubArray subArray = new MaxSubArray();
		System.out.println(subArray.maxSubArray(input));
	}

}
