package com.practice.diviceandconquer;

import java.util.Stack;

/*
Leetcode #416. Partition Equal Subset Sum
Given a non-empty array containing only positive integers, find if the array can be partitioned into 
two subsets such that the sum of elements in both subsets is equal.
*/
public class SubsetSumKPartitions {
	public static void main(String[] s) {
		int[] data = {1, 5, 11, 5, 7, 33, 33, 7};
		//int[] data = {7, 6, 9, 5, 19, 33, 104};
		
		SubsetSumKPartitions subset = new SubsetSumKPartitions();
		subset.canPartition(data);
	}
	private void subset(int[] input, int sum, int index, int check, Stack<Integer> stack) {
		if(sum > check || index >= input.length) {
			stack.pop();
			return;
		}
		stack.push(input[index]);
		if(sum == check)
			return;
		
		

		int stackSize = stack.size();
		subset(input, (sum + input[index]), index + 1, check, stack);
		if(stack.size() == stackSize) {
			return;
		}
		else {
			subset(input, sum, index + 1, check, stack);
			
		}
		//stack.pop();
		
	}
	
	public void canPartition(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		for (int ele : nums) {
			sum += ele;
		}
		/*if(sum % 2 != 0)
			return false;
		else */
		
		subset(nums, 0, 0, sum / 2, stack);
		
		printStack(stack);
	}
	
	private void printStack(Stack<Integer> stack) {
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	
	

}
