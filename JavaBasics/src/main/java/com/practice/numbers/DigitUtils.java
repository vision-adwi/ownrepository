package com.practice.numbers;

public class DigitUtils {
	//#1295 Leetcode
	public static int digitCount(int number) {
		return (number == 0) ? 1 : computeDigitCount(number, 0);
	}
	
	private static int computeDigitCount(int dividend, int digit) {
		if(dividend == 0)
			return digit;
		
		return computeDigitCount((dividend / 10), digit + 1);
	}
	
	public static int reverse(int number) {
		return reverseDigits(number, 0);
	}
	
	private static int reverseDigits(int dividend, int reversed) {
		if(dividend == 0)
			return reversed;
		
		reversed = (reversed * 10) + (dividend % 10);
		return reverseDigits((dividend / 10), reversed);
	}
	
	public static boolean isDigitCountEven(int number) {
		return (DigitUtils.digitCount(number) % 2) == 0;
	}
	
	public static int addDigits(int number) {
		return addAllDigits(number, 0);
	}
	
	private static int addAllDigits(int dividend, int sum) {
		if(dividend == 0)
			return sum;
		
		sum = sum + (dividend % 10);
		return addAllDigits((dividend / 10), sum);
	}
	
	public static int addFirstAndLastDigits(int number) {
		return addFirstLastDigits((number / 10), (number % 10));
	}
	
	private static int addFirstLastDigits(int dividend, int sum) {
		if(dividend < 10) {
			sum = sum + dividend;
			return sum;
		}

		return addFirstLastDigits((dividend / 10), sum);
	}
	
	public static void evenOddDigitCount(int number) {
		int dividend = number;
		int even = 0;
		int odd = 0;
		while(dividend > 0) {
			int digit = dividend % 10;
			if((digit % 2) == 0) 
				even++;
			else
				odd++;
			dividend = dividend / 10;
		}
		System.out.println("Count of even digits : " + even);
		System.out.println("Count of odd digits  : " + odd);
	}
/*	
	public static void main(String[] s) {
		System.out.println("0 : " + reverse(0));
		System.out.println("1 : " + reverse(1));
		System.out.println("9 : " + reverse(9));
		System.out.println("100 : " + reverse(100));
		System.out.println("99 : " + reverse(99));
		System.out.println("1234 : " + addDigits(1));
		System.out.println("1234 : " + addFirstAndLastDigits(9));
		evenOddDigitCount(133456);
	}
*/
}
