package com.practice.diviceandconquer;
/*
Leetcode#303. Range Sum Query - Immutable
Given an integer array nums, find the sum of the elements between indices i and j (i <= j), inclusive.
*/
public class RangeSumQuery {
    int[] mem;
    public RangeSumQuery(int[] nums) { 
        if(nums.length > 0) {
            mem = new int[nums.length + 1];
            for(int i = nums.length - 1; i >= 0; i--) {
                mem[i] = mem[i + 1] + nums[i];            
            }
        }        
    }
    
    public int sumRange(int i, int j) {
        if(mem == null)
            return 0;
        
        return mem[i] - mem[j+1];
    }
}
