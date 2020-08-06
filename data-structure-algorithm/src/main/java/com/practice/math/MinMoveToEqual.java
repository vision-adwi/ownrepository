package com.practice.math;

import java.util.Arrays;

public class MinMoveToEqual {
    public int minMoves2(int[] nums) {
    	int[] diff = new int[nums.length - 1];
    	Arrays.sort(nums);
    	for(int i = 1; i < nums.length; i++) {
    		diff[i - 1] = nums[i] - nums [i - 1];
    	}
    	
    	int mid = (nums.length / 2) - 1;
    	
    	
    	int cumlation = 0, sum = 0;
    	int previous_sum = Integer.MAX_VALUE;
    	
		while (true) {
			int index = mid;
			while (index-- >= 0) {
				cumlation = cumlation + diff[index];
				sum = sum + cumlation;
			}

			index = mid + 1;
			cumlation = 0;
			while (index++ < diff.length) {
				cumlation = cumlation + diff[index];
				sum = sum + cumlation;
			}
			if (sum < previous_sum) {
				previous_sum = sum;
				sum = 0;
				mid--;
			} else {
				break;
			}
		}
		
		return -1;
    		
        
    }
}
