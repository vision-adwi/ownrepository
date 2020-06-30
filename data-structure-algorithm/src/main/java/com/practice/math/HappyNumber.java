package com.practice.math;
/*
Leetcode#202. Happy Number
Write an algorithm to determine if a number n is "happy".
A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
Return True if n is a happy number, and False if not.
*/
public class HappyNumber {
	public boolean isHappy(int n) {
        while(n > 9) {
            n = sumOfSquare(n, 0);
        }
        if(n == 7 || n == 1)
            return true;
        else
            return false;
        
    }
    
    private int sumOfSquare(int n, int square) {
        if(n == 0)
            return square;
        
        int digit = n % 10;
        square = square + (digit * digit);
        
        return sumOfSquare(n/10, square);
    }	
}
