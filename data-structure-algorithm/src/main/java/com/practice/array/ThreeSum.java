package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Leetcode#15. 3Sum
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.
*/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();		
		for(int i = 0; i < nums.length - 2; i++) {
			if(i > 0 && nums[i] == nums[i - 1])
				continue;
			int target = -nums[i];
			int left = i + 1;
			int right = nums.length - 1;
			while(left < right) {
				if((nums[left] + nums[right]) == target) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    while(left < right && nums[left] == nums[left + 1]) left++;
				    while(left < right && nums[right] == nums[right - 1]) right--;
				
				    left++;
				    right--;
				}
                else if((nums[left] + nums[right]) > target) {
                    right--;
                }
                else {
                    left++;
                }
				
			}
		}
		
		return result;
    }

    public static void main(String[] s) {
    	ThreeSum ts = new ThreeSum();
    	ts.threeSum(new int[] {-1,0,1,2,-1,-4});
    }
}
