package com.practice.sorting;
/*
Leetcode#179. Largest Number
Given a list of non negative integers, arrange them such that they form the largest number.
*/
public class LargestNumber {
	public String largestNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        
        StringBuilder builder = new StringBuilder();
        for(int i = nums.length - 1; i >= 0; i--) {
        	if(builder.length() == 0 && nums[i] == 0)
        		continue;
        	
        	builder.append(nums[i]);
        }
        
        if(builder.length() == 0)
        	builder.append(0);

        return builder.toString();
    }
	
	
	private void quickSort(int[] elements, int left, int right) {
		if ( left < right) {
			int i = left - 1;

			int pivot = elements[right];
			int tmp;
			for (int j = left; j <= right; j++) {
				if (lte(elements[j], pivot)) {
					tmp = elements[++i];
					elements[i] = elements[j];
					elements[j] = tmp;
				}
			}

			quickSort(elements, left, (i - 1));
			quickSort(elements, (i + 1), right);

		}
	}
	
	private boolean lte(int ele, int pivot) {
		String a = String.valueOf(ele);
		String b = String.valueOf(pivot);
		
		long ab = Long.parseLong(a + b);
		long ba = Long.parseLong(b + a);
		
		return ab <= ba;
	}

}
