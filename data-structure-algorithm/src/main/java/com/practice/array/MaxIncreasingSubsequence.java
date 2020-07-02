package com.practice.array;
/*
Leetcode#674. Longest Continuous Increasing Subsequence
Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
*/
public class MaxIncreasingSubsequence {
	public int findLengthOfLCIS(int[] nums) {
		if(nums.length == 0)
			return 0;
		
        int base = nums[0];
        int max = 1;
        
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
        	if(base < nums[i]) {
        		count++;
        	}
        	else {
        		if(count > max)
        			max = count;
        		
        		count = 1;
        	}
        	base = nums[i];
        }
        
        if(count > max)
			max = count;
        
        return max;
    }
}
