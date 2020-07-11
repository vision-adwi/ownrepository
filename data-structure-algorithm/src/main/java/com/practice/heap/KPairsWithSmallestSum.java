package com.practice.heap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
/*
Leetcode#373. Find K Pairs with Smallest Sums
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
Define a pair (u,v) which consists of one element from the first array and one element from the second array.
Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
*/
public class KPairsWithSmallestSum {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		Queue<Pair> maxHeap = new PriorityQueue<Pair>(
				(e1, e2) -> e2.getValue().compareTo(e1.getValue()));

		for(int i = 0; i < nums1.length; i++) {
			if(maxHeap.size() == k && (nums1[i] + nums2[0]) > maxHeap.peek().getValue())
				break;
			
			for(int j = 0; j < nums2.length; j++) {
				if(maxHeap.size() == k && (nums1[i] + nums2[j]) > maxHeap.peek().getValue())
					break;
				
				maxHeap.offer(new Pair(nums1[i], nums2[j]));
				if(maxHeap.size() > k)
					maxHeap.poll();
			}
		}
        
		List<List<Integer>> result = new LinkedList<>();
		while(!maxHeap.isEmpty())
			result.add(0, maxHeap.poll().getKey());

        return result;
    }
	
	private class Pair {
		List<Integer> thePair;
		int sum;
		
		Pair(int num1, int num2) {
			this.thePair = Arrays.asList(num1, num2);
			this.sum = num1 + num2;
		}
		
		public List<Integer> getKey() {
			return thePair;
		}
		
		public Integer getValue() {
			return sum;
		}
	}
	
	public static void main(String[] s) {
		KPairsWithSmallestSum smallestSum = new KPairsWithSmallestSum();
		
		int[] nums1 = {1, 1, 2};
		int[] nums2 = {1, 2, 3};
		System.out.println(smallestSum.kSmallestPairs(nums1, nums2, 2));
	}
}
