package com.practice.slidingwindow;
/*
Leetcode#1004. Max Consecutive Ones III
Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
Return the length of the longest (contiguous) subarray that contains only 1s. 
*/
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int i = 0, j = 0;
        while(j < A.length) {
            if(A[j] == 0)
                K--;
            
            if(K < 0) {
                if(A[i] == 0)
                    K++;
                
                i++;
            }
            j++;
        }
        
        return j - i;
    }
}
