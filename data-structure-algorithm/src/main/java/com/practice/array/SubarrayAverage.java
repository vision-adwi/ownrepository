package com.practice.array;

import java.util.LinkedList;
import java.util.Queue;
/*
Leetcode#1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
Given an array of integers arr and two integers k and threshold.

Return the number of sub-arrays of size k and average greater than or equal to threshold.
*/
public class SubarrayAverage {
	public int numOfSubarrays(int[] arr, int k, int threshold) {
		Queue<Integer> queue = new LinkedList<>();
		
		int sum = 0;
		int count = 0;
		for(int num : arr) {
			queue.offer(num);
			sum = sum + num;
			if(queue.size() > k) {
				int subtract = queue.poll();
				sum = sum - subtract;
			}
			
			if(queue.size() == k) {
				double average = sum / k;
				if(average >= threshold)
					count++;
			}
		}
		
        return count;
    }
	
	public int numOfSubarrays1(int[] arr, int k, int threshold) {
		int i = -1;
		
		int sum = 0, count = 0;
		for(int j = 0; j < arr.length; j++) {
			sum = sum + arr[j];
			if((j - i) == k) {
				double average = sum / k;
				if(average >= threshold)
					count++;
				
				sum = sum - arr[++i];
			}
		}
		
		return count;
	}

}
