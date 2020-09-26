package com.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
Leetcode#349. Intersection of Two Arrays
Given two arrays, write a function to compute their intersection.
*/
public class IntersectionArrays {
	public int[] intersection_sort(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		List<Integer> intersection = new ArrayList<>();
		int i = 0, j = 0;
		while(i < nums1.length && j < nums2.length) {
			if(nums1[i] == nums2[j]) {
				if(intersection.isEmpty() || intersection.get(intersection.size() - 1) != nums1[i]) {
					intersection.add(nums1[i]);
				}

				++i; ++j;
			}
			else if(nums1[i] > nums2[j]) {
				++j;
			}
			else {
				++i;
			}
		}
		
		return intersection.stream()
				.mapToInt(p -> p.intValue()).toArray();
/*		
		List<Integer> result = new ArrayList<>();
		for(int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
			while(i < (nums1.length - 1) && nums1[i] == nums1[i+1])
				i++;
			
			while(j < (nums2.length - 1) && nums2[j] == nums2[j+1])
				j++;
			
			if(nums1[i] == nums2[j]) {
				result.add(nums1[i]);
				i++; j++;
			}
			else if(nums1[i] > nums2[j]) {
				j++;
			}
			else {
				i++;
			}
		}
		
		return result.stream()
	        	.mapToInt(a -> a.intValue())
	        	.toArray();*/
	}
	
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> firstSet = new HashSet<>();
        for(int num : nums1)
            firstSet.add(num);
        
        Set<Integer> resultSet = new HashSet<>();
        for(int num : nums2) 
            if(firstSet.contains(num))
                resultSet.add(num);
        
        int[] result = resultSet.stream()
        	.mapToInt(a -> a.intValue())
        	.toArray();
       
        return result;
    }
}
