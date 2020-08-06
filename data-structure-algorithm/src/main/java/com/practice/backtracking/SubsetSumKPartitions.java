package com.practice.backtracking;
import java.util.stream.IntStream;

/*
Leetcode #698. Partition to K Equal Sum Subsets
Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
*/
public class SubsetSumKPartitions {
	public static void main(String[] s) {
		//int[] data = {4, 3, 2, 3, 5, 2, 1};
		//int[] data = {7, 6, 9, 5, 19, 33, 104};
		int[] data = {10,10,10,7,7,7,7,7,7,6,6,6};
		
		SubsetSumKPartitions subset = new SubsetSumKPartitions();
		System.out.println(subset.canPartitionKSubsets(data, 3));
	}
	
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = IntStream.of(nums)
				.sum();

		if(sum % k != 0)
			return false;

		return fillBucket(nums, new boolean[nums.length], 0, 0, sum / k, k);
    }
	
	private boolean fillBucket(int[] nums, boolean[] picked, int next, int sum, int target, int k) {
		if(sum > target)
			return false;
		
		if(k == 1)
			return true;
		
		if(sum == target)
			return fillBucket(nums, picked, 0, 0, target, k - 1);;

		for(int i = next; i < nums.length; i++) {
			if(!picked[i]) {
				picked[i] = true;
				if(fillBucket(nums, picked, i + 1, sum + nums[i], target, k)) {
					return true;
				}
				picked[i] = false;
			}
		}
		
		return false;
	}

}
