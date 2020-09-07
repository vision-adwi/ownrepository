package com.practice.array;

public class RemoveUtil {
	/*
	Leetcode#26. Remove Duplicates from Sorted Array
	Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
	Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
	*/
    public static int removeDuplicates(int[] nums) {
    	int i = 0, j = 0;
    	while(i < nums.length) {
    		if((i == nums.length - 1) || nums[i] != nums[i + 1])
    			nums[j++] = nums[i];
    		i++;
    	}
    	
    	return j;
    }
    /*
    Leetcode#27. Remove Element
    Given an array nums and a value val, remove all instances of that value in-place and return the new length.
	Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
	The order of elements can be changed. It doesn't matter what you leave beyond the new length.
    */
    public int removeElement(int[] nums, int val) {
    	int j = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] != val)
        		nums[j++] = nums[i];
        }
        
    	return j;
    }
    
	public static void main(String[] args) {
		int[] values = {23, 23, 23, 23, 23, 28, 29, 33, 33, 38, 38, 40, 40, 55, 55};
		print(values, values.length);
		int newLength = removeDuplicates(values);
		print(values, newLength);

	}
	
	private static void print(int[] values, int arraySize) {
		System.out.print("[ ");
		for (int i = 0; i < arraySize; i++) {
			System.out.print(values[i] + " ");

		}
		System.out.println("]");
	}

}
