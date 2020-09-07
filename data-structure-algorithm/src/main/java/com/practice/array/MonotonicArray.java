package com.practice.array;
/*
Leetcode#896. Monotonic Array
An array is monotonic if it is either monotone increasing or monotone decreasing.
An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
Return true if and only if the given array A is monotonic.
*/
public class MonotonicArray {
	public boolean isMonotonic(int[] A) {
		if(A.length <= 1)
			return true;
		
		int i = 1;
		while(i < A.length && A[i - 1] == A[i])
			i++;
		
		int k = i;
		while(i < A.length && A[i - 1] <= A[i])
			i++;
		
		if(i == A.length)
			return true;
		if(i > k)
			return false;
		
		while(i < A.length && A[i - 1] >= A[i])
			i++;
		
		return i == A.length;
	}
	
	public boolean isMonotonic_old(int[] A) {
		if (A.length != 1) {
			int index = isIncreasing(A);
			if (index == 0)
				return true;

			if (index > 0) {
				for (int i = index; i < A.length - 1; i++) {
					if (A[i] > A[i + 1])
						return false;
				}
			} else {
				for (int i = Math.abs(index); i < A.length - 1; i++) {
					if (A[i] < A[i + 1])
						return false;
				}

			}
		}

		return true;
	}
    
    private int isIncreasing(int[] A) {
    	int def = 0;
    	for(int i = 0; i < A.length - 1; i++) {
    		if(A[i] == A[i+1])
    			continue;
    		
    		if(A[i] > A[i+1]) //Decreasing
    			return -(i+1);
    		else //decreasing
    			return (i+1);
    	}
    	
    	return def;
    }

}
