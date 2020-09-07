package com.practice.array;
/*
Leetcode#1304. Find N Unique Integers Sum up to Zero
Given an integer n, return any array containing n unique integers such that they add up to 0.
*/		
public class UniqueSumZero {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        
        int i = n / 2;
        int j = i - 1;
        if( (n % 2) != 0 ) {//odd
            result[i] = 0;
            i = i + 1;
        }
        
        int left = 0;
        int right = 0;
        while(j >= 0) {
            result[i++] = ++right;
            result[j--] = --left;
        }
        
        return result;
 
    }
    
    public int[] sumZero_new(int n) {
        boolean even = (n % 2) == 0;
        int end = n / 2;
        
        int[] result = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            if(even && (end == 0))
                end--;
            
            result[i] = end--;
        }
        
        return result;
    }
}
