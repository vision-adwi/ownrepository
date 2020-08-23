package com.practice.diviceandconquer;

import java.util.Arrays;
/*
Leetcode#300. Longest Increasing Subsequence
Given an unsorted array of integers, find the length of longest increasing subsequence.
*/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        
        int[] mem = new int[nums.length];
        Arrays.fill(mem, 1);
        
        int max = 1;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    mem[i] = Math.max(mem[i], mem[j] + 1);
                }
            }
            max = Math.max(max, mem[i]);
        }
        
    	return max;
    }
    
    public int lengthOfLIS_dc(int[] nums) {
    	return findLISLength(nums, 0, Integer.MIN_VALUE);
    }
    
    private int findLISLength(int[] nums, int index, int number) {
    	if(index >= nums.length)
    		return 0;
    	
    	int l1 = 0;
    	int l2 = 0;
    	if(nums[index] > number) {
    		l1 = 1 + findLISLength(nums, index + 1, nums[index]);
    	}
    	l2 = findLISLength(nums, index + 1, number);
    	
    	return Math.max(l1, l2);
    }
}
