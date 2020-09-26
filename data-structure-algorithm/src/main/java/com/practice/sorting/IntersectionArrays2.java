package com.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Leetcode#350. Intersection of Two Arrays
Given two arrays, write a function to compute their intersection.
*/
public class IntersectionArrays2 {
	public int[] intersection_sort(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		List<Integer> intersection = new ArrayList<>();
		int i = 0, j = 0;
		while(i < nums1.length && j < nums2.length) {
			if(nums1[i] == nums2[j]) {
				intersection.add(nums1[i]);
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
	}
	
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums1) {
        	Integer freq = freqMap.get(num);
        	if(freq == null)
        		freqMap.put(num, 1);
        	else
        		freqMap.put(num, ++freq);
        }
        
        List<Integer> resultSet = new ArrayList<>();
        for(int num : nums2) {
        	Integer freq = freqMap.get(num);
        	if(freq != null && freq != 0) {
        		resultSet.add(num);
        		freqMap.put(num, --freq);
        	}
        }
        
        return resultSet.stream()
        	.mapToInt(a -> a.intValue())
        	.toArray();
    }
}
