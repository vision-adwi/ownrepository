package com.practice.array;

import java.util.Arrays;

/*
Leetcode#414. Third Maximum Number
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist,
return the maximum number. The time complexity must be in O(n).
*/
public class ThirdHighest {
	int highest = Integer.MIN_VALUE;
	int secondHighest = Integer.MIN_VALUE;
	int thirdHighest = Integer.MIN_VALUE;
	int count = 0;

	public void findHighest_(int[] values) {
		for (int value : values) {
			if(count != 3) {
				if((count == 0) || (count == 1 && value != highest)
						|| (count == 2 && value != highest && value != secondHighest)){
					count++;
				}
			}
			if (value != highest && value != secondHighest && value != thirdHighest) {
				if (value > highest) {
					thirdHighest = secondHighest;
					secondHighest = highest;
					highest = value;
				} else if (value > secondHighest) {
					thirdHighest = secondHighest;
					secondHighest = value;
				} else if (value > thirdHighest) {
					thirdHighest = value;
				}
			}
		}
	}
	
	public int findHighest(int[] nums) {
		int[] highest = new int[3];
		Arrays.fill(highest, Integer.MIN_VALUE);
		
		for(int i = 0; i < nums.length; i++) {
			for(int k = 0; k <= 2; k++) {
				if(nums[i] == highest[k])
					break;
				
				int j = 2;
				if(nums[i] > highest[k]) {
					while(j-- > k) {
						highest[j] = highest[j - 1];
					}
					
					highest[k] = nums[i];
					break;
				}
				
			}
		}
		
		return highest[2] == Integer.MIN_VALUE ? highest[1] : highest[2];
	}

	public void print() {
		System.out.println("Highest: " + highest);
		System.out.println("Second Highest: " + secondHighest);
		System.out.println("Third Highest: " + thirdHighest);
	}

	public static void main(String[] args) {
		int[] values = {1, 2, 2, -2147483648};//23, 23, 24, 24};//, 12, 27, 23, 28, 28, 27, 23, 30, 15, 40, 35, 33, 38, 57, 40, 30, 23, 57};
		
		ThirdHighest highest = new ThirdHighest();
		highest.findHighest(values);
		
		highest.print();
	}

}
