package com.practice.array;
/*
Leetcode#268. Missing Number
*/
public class MissingNumber {
	public int missingNumber(int[] nums) {
		int missing = nums.length;
		for(int i = 0; i < nums.length; i++) {
			missing = missing ^ i;
			missing = missing ^ nums[i];
		}
		
		return missing;
	}

}
