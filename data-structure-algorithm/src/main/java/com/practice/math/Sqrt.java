package com.practice.math;
/*
Leetcode#69. Sqrt(x)
Implement int sqrt(int x).
Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Leetcode#367. Valid Perfect Square - Similar
*/
public class Sqrt {
    public int mySqrt(int x) {
        if (x < 2)
            return x;
        
        long start = 0;
        long end = x;
        
        while (start < end) {
            long mid = (start + end) / 2;
                        
            if ((mid + 1) * (mid + 1) > x && mid * mid <= x) 
                return (int) mid;

            else if (mid * mid > x) 
                end = mid;
        
            else 
                start = mid;
        }
        
        return 0;
        
    }
    
    public static void main(String[] s) {
    	Sqrt sqrt = new Sqrt();
    	System.out.println(sqrt.mySqrt(83));
    	//sqrt.mySqrt(80);
    }

}
