package com.practice.math;
/*
Leetcode#633. Sum of Square Numbers
Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
*/
public class TwoSumSquare {
    public boolean judgeSquareSum(int c) {
        double sqrt = Math.sqrt(c);
        int right = (int)(Math.floor(sqrt));
        int left = 0;
        
        while(left < right) {
        	int sum = (left*left) + (right*right);
        	if(sum == c)
        		return true;
        	
        	if(sum > c)
        		right--;
        	else
        		left++;
        }
        
        return false;
    }
    

}
