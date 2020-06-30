package com.practice.math;
/*
Leetcode# 7. Reverse Integer
*/
public class ReverseDigit {
	public int reverse(int x) {
        return reverseAll(x, 0);
    }
	
	private int reverseAll(int n, int reverse) {
		if(n == 0)
			return reverse;
		
		if(reverse > (Integer.MAX_VALUE / 10) || reverse < (Integer.MIN_VALUE / 10))
			reverse = 0;
		else
			reverse = (reverse * 10) + (n % 10);
		
		return reverseAll(n / 10, reverse);
	}
	
	public static void main(String[] s) {
		ReverseDigit rev = new ReverseDigit(); //1,534,236,469
		int digit = 1534236461;
		System.out.println(digit + " : " + rev.reverse(digit)); //2,147,483,647
	}

}
