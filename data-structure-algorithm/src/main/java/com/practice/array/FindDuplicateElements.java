package com.practice.array;

import java.util.ArrayList;
import java.util.List;

/*
Leetcode#442. Find All Duplicates in an Array
Given an array of integers, 1 <= a[i] <= n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?
*/
public class FindDuplicateElements {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int data : nums) {
            int index = Math.abs(data) - 1;
            if(nums[index] < 0)
                result.add(index + 1);
            
            nums[index] = - nums[index];
        }
        
        return result;
    }

}
