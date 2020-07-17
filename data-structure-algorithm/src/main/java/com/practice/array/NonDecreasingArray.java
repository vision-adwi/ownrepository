package com.practice.array;

import java.util.ArrayList;
import java.util.List;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        boolean flag = false;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] > nums[i]) {
            	int j = i + 1;
            	
                if(flag)
                    return false;
                else
                    flag = true;
            }
        }
        
        return true;
    }

}
