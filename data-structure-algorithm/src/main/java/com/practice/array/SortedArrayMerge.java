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
		int index = nums1.length - 1;
		while(true) {
			if(m == 0 && n == 0)
				break;
			
			if((n == 0) || (m > 0) && nums1[m - 1] > nums2[n - 1]) {
				nums1[index--] = nums1[m - 1];
				m--;
			}
			else {
				nums1[index--] = nums2[n - 1];
				n--;
			}
		}
		
	}
}
