package com.practice.string;
/*
Leetcode#415. Add Strings
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
public class BigInteger {
	public String addStrings(String num1, String num2) {
		int l1 = num1.length() - 1;
		int l2 = num2.length() - 1;
		
		int carry = 0;
		
		StringBuilder result = new StringBuilder();
		while(l1 >= 0 || l2 >= 0) {
			int addend1 = 0;
			int addend2 = 0;
			if(l1 >= 0)
				addend1 = Character.getNumericValue(num1.charAt(l1));
			if(l2 >= 0)
				addend2 = Character.getNumericValue(num2.charAt(l2));
			
			int sum = addend1 + addend2 + carry;
			carry = sum / 10;
			result.append(Character.digit((sum % 10), 10));
				
			l1--; l2--;
		}
		
		if(carry > 0)
			result.append(Character.digit(carry, 10));
		
		return result.reverse().toString();
	}
 
}
