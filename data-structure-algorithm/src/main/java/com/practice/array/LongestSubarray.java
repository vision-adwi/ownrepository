package com.practice.array;

public class LongestSubarray {
    public int longestSubarray(int[] nums) {
    	int i = 0;
    	int count1 = 0;
    	int count2 = 0;
    	int max = 0;
    	
    	while(true) {
    		while(nums[i++] == 1)
    			count1++;
    		
    		if(nums[i] == 0)
    			continue;
    		
    		while(nums[i++] == 1)
    			count2++;
    		
    		if(max < (count1 + count2))
    			max = count1 + count2;
    		
    		count1 = count2;
    	}
        
    }
}
