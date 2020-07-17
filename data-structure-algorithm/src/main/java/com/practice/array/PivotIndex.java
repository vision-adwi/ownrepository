package com.practice.array;
/*
Leetcode#724. Find Pivot Index
Given an array of integers nums, write a method that returns the "pivot" index of this array.
We define the pivot index as the index where the sum of all the numbers to the left of the index is equal to the sum of all the numbers to the right of the index.
If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
*/
public class PivotIndex {
    public int pivotIndex(int[] nums) {
    	if(nums.length == 0)
    		return -1;
    	
        int sum = 0;
        for(int num : nums) {
            sum = sum + num;
        }
        
        int firstHalf = 0;
        int pivot = nums[0];
        for(int i = 1; i < nums.length; i++) {
        	if((firstHalf * 2) == (sum - pivot))
                return i - 1;
        	
        	pivot = nums[i];
        	firstHalf = firstHalf + nums[i - 1];
            
        }
        
        if(firstHalf == 0)
        	return nums.length - 1;
        else
        	return -1;
    }
    
    public static void main(String[] s) {
    	PivotIndex pivot = new PivotIndex();
    	System.out.println(pivot.pivotIndex(new int[] {-1,-1,0,1,1,0}));
    }
}
