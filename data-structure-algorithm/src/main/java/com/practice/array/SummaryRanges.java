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
    	if(nums.length == 0)
            return result;
    	
    	int left = nums[0];
    	int right = nums[0];
    	for(int i = 1; i < nums.length; i++) {
    		if(nums[i] == right + 1) {
    			right = nums[i];
    		}
    		else {
    			addToList(result, left, right);
    			left = right = nums[i];
    		}
    	}
    	addToList(result, left, right);        
    	return result;
    }
    
    private void addToList(List<String> result, int left, int right) {
    	if(left == right) {
			result.add(String.valueOf(left));
		}
		else {
			StringBuilder builder = new StringBuilder();
			builder.append(String.valueOf(left)).append("->").append(String.valueOf(right));
			result.add(builder.toString());
		}
    }
}
