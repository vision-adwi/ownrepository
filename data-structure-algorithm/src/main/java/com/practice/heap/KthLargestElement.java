package com.practice.heap;

import java.util.PriorityQueue;
import java.util.Queue;
/*
Leetcode#215. Kth Largest Element in an Array
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
*/
public class KthLargestElement {
	public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(Integer ele : nums) {
        	minHeap.offer(ele);
        	if(minHeap.size() > k) 
        		minHeap.poll();
        }
        
        return minHeap.poll();
    }
	
	public static void main(String[] s) {
		int[] input = {3,2,1,5,6,4};
		KthLargestElement largest = new KthLargestElement();
		System.out.println(largest.findKthLargest(input, 2));
	}
}
