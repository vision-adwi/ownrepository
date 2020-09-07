package com.practice.array;
/*
Leetcode#238. Product of Array Except Self
Given an array nums of n integers where n > 1,  return an array output such that output[i] is 
equal to the product of all the elements of nums except nums[i].
*/
public class ProdExceptSelf {
	public int[] productExceptSelf_(int[] nums) {
		int len = nums.length;
		int[] result = new int[len];
		
		result[0] = 1;
		for(int i = 1; i < len; i++) {
			result[i] = result[i - 1] * nums[i - 1];
		}
		
		int right = 1;
		for(int i = len - 2; i >= 0; i--) {
			result[i] = result[i] * (right = right * nums[i + 1]);
		}
        
		return result;
    }
	
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] result = new int[len];
		
		result[len - 1] = 1;
		for(int i = len - 2; i >= 0; i--) {
			result[i] = result[i + 1] * nums[i + 1];
		}
		
		int right = 1;
		for(int i = 1; i < len; i++) {
			result[i] = result[i] * (right *= nums[i - 1]);
		}
		
		return result;
	}

}
