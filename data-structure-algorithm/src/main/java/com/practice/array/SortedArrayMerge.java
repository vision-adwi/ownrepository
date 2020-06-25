package com.practice.array;
/*
Leetcode#88. Merge Sorted Array
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
*/
public class SortedArrayMerge {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int j = 0;
		int pos = 0;
		for(; pos < m; pos++) {
			if(j >= n)
				break;
			
			int ele = nums2[j];
			if(nums1[pos] <= ele)
				continue;
			
			int idx = m;
			while(idx > pos) {
				nums1[idx] = nums1[idx - 1];
				
				idx--;
			}
			nums1[pos] = ele;
			m++; j++;
		}
		
		while(j < n) {
			nums1[pos++] = nums2[j++]; 
		}
    
	}
}
