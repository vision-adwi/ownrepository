package com.practice.array;

import java.util.LinkedList;
import java.util.List;
/*
Leetcode#989. Add to Array-Form of Integer
For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].
Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
*/		
public class AddToArray {
    public List<Integer> addToArrayForm(int[] A, int K) {
    	List<Integer> result = new LinkedList<>();
    	
    	int remainder = 0;
    	int index = A.length - 1;
    	while(K != 0 || index >= 0 || remainder > 0) {
    		int digit = (K == 0) ? 0 : (K % 10);
    		int arr = (index < 0) ? 0 : A[index];
    		int sum = remainder + digit + arr;
    		
    		result.add(0, sum % 10);
    		
    		remainder = sum / 10;
    		index--;
    		K = K / 10;    		
    	}
        
    	return result;
    }
    
    public static void main(String[] s) {
    	AddToArray arr = new AddToArray();
    	arr.addToArrayForm(new int[] {1, 2,0,0}, 5);
    	
    }
}
