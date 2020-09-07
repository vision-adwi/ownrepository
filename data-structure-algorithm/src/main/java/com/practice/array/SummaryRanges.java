package com.practice.array;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode#228. Summary Ranges
Given a sorted integer array without duplicates, return the summary of its ranges.
*/
public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();

		int i = 0;
		while(i < nums.length) {
			int start = nums[i++];
			while(i < nums.length && nums[i] == (nums[i - 1] + 1))
				i++;
			
			StringBuilder builder = new StringBuilder();
			builder.append(String.valueOf(start));
			if(start != nums[i - 1]) {
				builder.append("->").append(String.valueOf(nums[i - 1]));	
			}
			result.add(builder.toString());
		}
		
		return result;
	}

}
