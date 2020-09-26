package com.practice.bitwise;

public class Classical {
    /*
    Leetcode#371. Sum of Two Integers
    Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
    */
    public int getSum(int a, int b) {
        int carry = 0, sum = 0;
        do {
            sum = a ^ b;
            carry = a & b;
            a = sum;
            b = carry << 1;
        } while(b != 0);
        
        return sum; 
    }
    
	/*
	Leetcode#338. Counting Bits
	Given a non negative integer number num. For every numbers i in the range 0 <= i <= num 
	calculate the number of 1's in their binary representation and return them as an array.
	*/
	public int[] countBits(int num) {
		int[] setBitsCountArray = new int[num + 1];
		for(int i = 1; i <= num; i++) {
			int setBitsCount = setBitsCountArray[(i / 2)];
			if((i & 1) == 1) { //odd
				setBitsCount = setBitsCount + 1;
			}
			
			setBitsCountArray[i] = setBitsCount;
		}
        
		return setBitsCountArray;
    }
	
    /*
    Leetcode#201. Bitwise AND of Numbers Range
    Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
    */
    public int rangeBitwiseAnd(int m, int n) {
        int shifts = 0;
        while(m != n) {
            shifts++;
            m = m >> 1;
            n = n >> 1;
        }
        
        return m << shifts;
    }
    
    /*
    Leetcode#477. Total Hamming Distance
    The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
    Now your job is to find the total Hamming distance between all pairs of the given numbers.
    */
    public int totalHammingDistance(int[] nums) {
        int total = 0;
    	for(int i = 0; i < 32; i++) {
    		int setBits = 0;
    		for(int j = 0; j < nums.length; j++) {
    			if((nums[j] & 1) == 1)
    				setBits++;

    			nums[j] = nums[j] >> 1;
    		}
    		total = total + (setBits * (nums.length - setBits));
    	}
    	
    	return total;
    }

}
