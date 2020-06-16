package com.practice.diviceandconquer;
/*
Leetcode #416. Partition Equal Subset Sum
Given a non-empty array containing only positive integers, find if the array can be partitioned into 
two subsets such that the sum of elements in both subsets is equal.
*/
public class SubsetSumEqualPartitions {
	public static void main(String[] s) {
		int[] data = {1, 5, 11, 5, 7, 33, 33, 7};
		//int[] data = {7, 6, 9, 5, 19, 33, 104};
		
		SubsetSumEqualPartitions subset = new SubsetSumEqualPartitions();
		System.out.println("Is subset sum can be equally paritioned - " + subset.canPartition(data));
	}
	private boolean subset(int[] input, int sum, int index, int check) {
		if(sum > check || index >= input.length)
			return false;
		
		if(sum == check)
			return true;

		if(subset(input, (sum + input[index]), index + 1, check)) {
			return true;
		}
		else {
			return subset(input, sum, index + 1, check);
		}
	}
	
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int ele : nums) {
			sum += ele;
		}
		if(sum % 2 != 0)
			return false;
		else 
			return subset(nums, 0, 0, sum / 2);
	}

}
