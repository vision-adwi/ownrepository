package com.practice.math;

import java.util.HashMap;
import java.util.Map;
/*
Leetcode#12. Integer to Roman
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
*/
public class IntegerToRoman {
	private Map<Integer, String> romanMap = new HashMap<>();
	{
		romanMap.put(1, "I");
		romanMap.put(5, "V");
		romanMap.put(10, "X");
		romanMap.put(50, "L");
		romanMap.put(100, "C");
		romanMap.put(500, "D");
		romanMap.put(1000, "M");
	}
	
	public String intToRoman(int N) {
		return convert(N, 1, new StringBuilder());
	}
	
	private String convert(int remainingDigit, int placeValue, StringBuilder roman) {
		if(remainingDigit == 0)
			return roman.toString();
		
		int digit = remainingDigit % 10;
		String romanDigit = calculate(digit, placeValue);
		if(romanDigit != null)
			roman.insert(0, romanDigit);
		
		return convert(remainingDigit / 10, placeValue * 10, roman);
	}
	
	private String calculate(int digit, int placeValue) {
		if(digit == 0)
			return null;
		
		if(digit == 5) {
			return romanMap.get(digit * placeValue);
		}
		
		StringBuilder builder = new StringBuilder();
		String romanDigit = romanMap.get(placeValue);
		if(digit == 4 || digit == 9) {
			builder.append(romanDigit);
			if(digit == 4)
				builder.append(romanMap.get(5 * placeValue));
			else
				builder.append(romanMap.get(10 * placeValue));
		}
		else {
			if(digit > 5 ) {
				digit = digit - 5;
				builder.append(romanMap.get(placeValue * 5));
			}
			
			for(int i = 0; i < digit; i++) {
				builder.append(romanDigit);
			}
		}

		return builder.toString();
	}
	
	public static void main(String[] s) {
		IntegerToRoman rom = new IntegerToRoman();
		System.out.println("1994 : " + rom.intToRoman(1994));
	}
}
