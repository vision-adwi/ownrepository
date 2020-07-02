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
		byte[] num1Bytes;
		byte[] num2Bytes;
		if (num1.length() < num2.length()) {
			num1Bytes = num1.getBytes();
			num2Bytes = num2.getBytes();
		} else {
			num1Bytes = num2.getBytes();
			num2Bytes = num1.getBytes();
		}
    	
    	StringBuilder builder = new StringBuilder();

    	int carry = 0;
    	int i = num1Bytes.length - 1;
    	int j = num2Bytes.length - 1;
    	while(i >= 0) {
    		int num1Digit = num1Bytes[i--] - 48;
    		int num2Digit = num2Bytes[j--] - 48;
    		
    		int sum = carry + num1Digit + num2Digit;
    		carry = sum / 10;
    		sum = sum % 10;
    		
    		builder.append((char)(sum + 48));
    	}

    	for(; j >= 0; j--) {
    		int numDigit = num2Bytes[j] - 48;

    		int sum = carry + numDigit;
    		carry = sum / 10;
    		sum = sum % 10;
    		
    		builder.append((char)(sum + 48));
    	}
    	
    	if(carry > 0)
    		builder.append((char)(carry + 48));
    	
    	return builder.reverse().toString();
    }
 
}
