package com.practice.array;

import java.util.Arrays;

public class TwoSumVariant {
	//Without duplicate input elements - find all unique pairs
	public int countPairs(int[] arr, int target) {
		Arrays.sort(arr);
		int count = 0;
		int i = 0;
		int j = arr.length - 1;
		while(i < j) {
			int sum = arr[i] + arr[j];
			if(sum == target) {
				count++;
				i++;
				//j--;
			}
			else if(sum > target) {
				j--;
			}
			else {
				i++;
			}
		}
		
		return count;
	}
	
	//With duplicate input elements - find all unique pairs
	public int countPairsUnique(int[] arr, int target) {
		Arrays.sort(arr);
		int count = 0;
		int i = 0;
		int j = arr.length - 1;
		while(i < j) {
			int sum = arr[i] + arr[j];
			if(sum == target) {
				count++;
				
				while(j >= i && arr[i] == arr[i+1])
					i++;
				
				i++;
			}
			else if(sum > target) {
				while(j >= i && arr[j] == arr[j-1])
					j--;
				
				j--;
			}
			else {
				while(j >= i && arr[i] == arr[i+1])
					i++;
				
				i++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] s) {
		int[] input = {5, 6, 1, 3, 7, 9, 4};
		int[] dup_input = {5, 6, 1, 3, 7, 9, 4, 3, 9, 6};
		TwoSumVariant variant = new TwoSumVariant();
		System.out.println(variant.countPairs(input, 10));
		System.out.println(variant.countPairsUnique(dup_input, 10));
		
		
	}

}
