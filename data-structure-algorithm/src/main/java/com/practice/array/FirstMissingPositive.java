package com.practice.array;
/*
Leetcode#41. First Missing Positive
Given an unsorted integer array, find the smallest missing positive integer.
*/
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        
        for(int i = 0; i < len; i++) {
        	while(nums[i] > 0 && nums[i] <= len) {
        		if(nums[i] == (i + 1))
        			break;
        		     		
        		int tmp = nums[nums[i] - 1];
        		if(tmp == nums[i]) {
        			nums[i] = -nums[i];
        			break;
        		}
        		
        		nums[nums[i] - 1] = nums[i];
        		nums[i] = tmp;
        	}        	
        	
        }
        
        for(int i = 0; i < len; i++) {
        	if(nums[i] != (i + 1))
        		return i + 1;
        }
        
        return len + 1;
    }

}
