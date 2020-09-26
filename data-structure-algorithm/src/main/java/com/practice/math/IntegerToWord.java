package com.practice.math;

import java.util.HashMap;
import java.util.Map;
/*
Leetcode#273. Integer to English Words
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
*/
public class IntegerToWord {
	Map intToWord = new HashMap() {
		{
			put(1, "One "); put(2, "Two "); put(3, "Three "); put(4, "Four "); put(5, "Five ");
			put(6, "Six "); put(7, "Seven "); put(8, "Eight "); put(9, "Nine ");
		}
	};
	
	Map tensToWord = new HashMap() {
		{
			put(1, "Eleven ");	put(2, "Twelve ");	put(3, "Thirteen "); put(4, "Fourteen ");
			put(5, "Fifteen ");	put(6, "Sixteen ");	put(7, "Seventeen "); put(8, "Eighteen ");
			put(9, "Nineteen "); put(0, "Ten ");
		}
	};
	
	Map tensWord = new HashMap() {
		{
			put(2, "Twenty ");	put(3, "Thirty ");	put(4, "Forty "); put(5, "Fifty ");
			put(6, "Sixty "); put(7, "Seventy "); put(8, "Eighty "); put(9, "Ninety ");
		}
	};
	
	Map<Integer, String> trio = new HashMap<Integer, String>() {
		{
			put(1, "");	put(2, "Thousand "); put(3, "Million "); put(4, "Billion ");
		}
	};
	
	public String numberToWords(int num) {
		if(num == 0)
            return "Zero";
		
		int numerals = 0;
		int radix = 0;
		
		int multiplier = 1;
		
		String result = "";
		while(num > 0) {
			if(radix > 0 && (radix % 3) == 0) {
				StringBuilder builder = untilHundred(numerals);
				if(builder.length() > 0)
					result = builder.append(trio.get((radix/3))).append(result).toString();
				numerals = 0;
				multiplier = 1;
			}
			radix++;
			
			numerals = numerals + ((num % 10) * multiplier);
			multiplier = multiplier * 10;

			num = num / 10;
		}
		result = untilHundred(numerals).append(trio.get((--radix/3)+1)).append(result).toString();

		return result.trim();
	}
	
    public StringBuilder untilHundred(int num) {
    	int ones = 0, tens = 0, hundreds = 0;

    	int i = 1;
    	while(num > 0) {
    		if(i == 1) ones = num % 10;
    		if(i == 2) tens = num % 10;
    		if(i == 3) hundreds = num % 10;
    		
    		i++;
    		num = num / 10;
    	}
    	
    	StringBuilder builder = new StringBuilder();
    	if(hundreds > 0) {
    		builder.append(intToWord.get(hundreds)).append("Hundred ");
    	}
    	if(tens == 1) {
    		builder.append(tensToWord.get(ones));
    		ones = 0;
    	}
    	else if(tens != 0) {
    		builder.append(tensWord.get(tens));
    	}
    	if(ones > 0) {
    		builder.append(intToWord.get(ones));
    	}

    	return builder;
    }
    
    public static void main(String[] s) {
    	IntegerToWord intToWord = new IntegerToWord();
    	intToWord.numberToWords(123);
    }

}
