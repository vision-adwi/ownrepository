package com.practice.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
/*
Leetcode#215. Kth Largest Element in an Array
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
This problem can be solved by one of these ways...
- Sorting(n*log(n))
- Heap(n*log(k))
- Partitioning(O(n))
*/
public class KthLargestElement {
	public int findKthLargest(int[] nums, int k) {
		return qSort(nums, 0, nums.length - 1, nums.length - k);
    }
	
	private int qSort(int[] nums, int start, int end, int position) {
		int i = start - 1;
		int pivot = nums[end];
		
		int tmp;
		for(int j = start; j <= end; j++) {
			if(nums[j] <= pivot) {
				tmp = nums[++i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}
		
		if(i == position) {
			return nums[i];
		}
		else if(i < position) {
			return qSort(nums, i + 1, end, position);
		}
		else {
			return qSort(nums, start, i - 1, position);
		}
	}
	
	public int findKthLargest_sorting(int[] nums, int k) {
		Arrays.sort(nums);
		
		return nums[nums.length - k];
    }
	
	public int findKthLargest_heap(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(Integer ele : nums) {
        	minHeap.offer(ele);
        	if(minHeap.size() > k) 
        		minHeap.poll();
        }
        
        return minHeap.poll();
    }
	
	public static void main(String[] s) {
		int[] input = {3,2,3,1,2,4,5,5,6};
//int[] input = {3,2,1,5,6,4};
		KthLargestElement largest = new KthLargestElement();
		System.out.println(largest.findKthLargest(input, 4));
	}
}
