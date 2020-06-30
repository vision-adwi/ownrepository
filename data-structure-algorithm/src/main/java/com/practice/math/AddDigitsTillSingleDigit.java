package com.practice.math;
/*
Leetcode# 258. Add Digits
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
*/
public class AddDigitsTillSingleDigit {
	public int addDigits(int num) {
		while ((num / 10) != 0) {
			num = sumDigits(num, 0);
		}

		return num;
	}

	private int sumDigits(int remainingDigits, int sum) {
		if (remainingDigits == 0)
			return sum;

		int digit = remainingDigits % 10;
		return sumDigits(remainingDigits / 10, sum + digit);
	}

	/*
	O(1)
	public int addDigits(int num) {
		if (num == 0)
			return 0;
		if (num % 9 == 0)
			return 9;
		
		return num % 9;
	}
	*/

}
