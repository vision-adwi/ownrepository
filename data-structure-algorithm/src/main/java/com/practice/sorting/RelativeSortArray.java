package com.practice.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
Leetcode#1122. Relative Sort Array
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  
Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
*/
public class RelativeSortArray {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int result[] = new int[arr1.length];
		Map<Integer, Integer> unique = new HashMap<>();
		for(int number : arr2) {
			unique.put(number, 0);
		}
		
		int index = result.length;
		for(int num : arr1) {
			Integer freq = unique.get(num);
			if(freq == null) {
				result[--index] = num;
			}
			else {
				unique.put(num, ++freq);
			}
		}
		
		Arrays.sort(result, index, result.length); 
		
		int from = 0; int to = 0;
		for(int number : arr2) {
			to = from + unique.get(number);
			Arrays.fill(result, from, to, number);
			from = to; 
		}
		
		return result;
	}
}
