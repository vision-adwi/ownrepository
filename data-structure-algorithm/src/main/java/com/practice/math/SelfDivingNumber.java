package com.practice.math;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode#728. Self Dividing Numbers
A self-dividing number is a number that is divisible by every digit it contains.
For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
Also, a self-dividing number is not allowed to contain the digit zero.
Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
*/
public class SelfDivingNumber {
	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> numbers = new ArrayList<>();
		for(int i = left; i <= right; i++) {
			if(isSelfDiving(i, i))
				numbers.add(i);
		}
        
		return numbers;
    }
	
	private static boolean isSelfDiving(int number, int remainingDigits) {
		if(remainingDigits == 0)
			return true;
		
		int digit = remainingDigits % 10;
		if( (digit == 0) || (number % digit) != 0 )
			return false;

		return isSelfDiving(number, number / 10);
	}
	
	public static void main(String[] s) {
		System.out.println(isSelfDiving(11,11));
		//System.out.println(selfDividingNumbers(1, 11));
	}

}
