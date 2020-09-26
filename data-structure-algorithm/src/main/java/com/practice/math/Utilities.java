package com.practice.math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utilities {    
    /*
    Leetcode#405. Convert a Number to Hexadecimal
    Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
    */
    public String toHex(int num) {
    	int octets = 8;
    	char[] hex = new char[octets];
    	
    	int mask = 0b1111;
    	while(--octets >= 0) {
    		int val = num & mask;
    		hex[octets] = (char)(((val / 10) == 1 ? 97 : 48) + (val % 10));
    		num = num >> 4;
    	}
        
    	int index = 0;
    	while(index < 7 && hex[index] == '0') {
    		index++;
    	}
    	
    	return new String(hex, index, (8 - index));
    }
    
    /*
    Leetcode#1344. Angle Between Hands of a Clock
    Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.
    */
	public static double angleClock(int hour, int minutes) {
        double min_hand_position = minutes * DEGREE_IN_A_MINUTE;
        double hour_hand_position = ((hour % 12) * DEGREE_IN_AN_HOUR) + (minutes * DEGREE_ADVANCE_PER_MIN);
        
        double angle = Math.abs(min_hand_position - hour_hand_position);
        return Math.min(angle, (360 - angle));      		
    }
	
	/*
	Leetcode#171. Excel Sheet Column Number
	Given a column title as appear in an Excel sheet, return its corresponding column number.
	*/	
	public static int titleToNumber(String s) {
		byte[] bytes = s.getBytes();
		int pos = bytes.length - 1;
		
		int sum = 0;
		int radix = 1;
		while(pos >= 0) {
			sum = sum + (radix * ((bytes[pos--] - 'A') + 1));
			radix = radix * 26;
		}
        
		return sum;
    }
	
	/*
	Leetcode#1154. Day of the Year
	Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.
	*/
	public static int dayOfYear(String date) {
		String[] ymd = date.split("-");
		return daysOfTheCurrentYear(Integer.parseInt(ymd[2]), Integer.parseInt(ymd[1]), 
				(Integer.parseInt(ymd[0])));
    }
	
	/*
	Leetcode#1185. Day of the Week
	Given a date, return the corresponding day of the week for that date.
	The input is given as three integers representing the day, month and year respectively.
	Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.

	Example 1:
	Input: day = 31, month = 8, year = 2019
	Output: "Saturday"
	*/
    public static String dayOfTheWeek(int day, int month, int year) {
    	if(year < 1971 || year > 2100) {
    		return "";
    	}
        int yearDiff = year - 1971;
        int currentYearDays = daysOfTheCurrentYear(day, month, year);
        int leapDays = (yearDiff + 2) / 4;
        
        int totalDays = (yearDiff * 365) + leapDays + currentYearDays;

        return days[(totalDays % 7) - 1];
    }
	
	//Leetcode#13. Roman to Integer
	public static int romanToInt(String s) {		
		int intValue = 0;
		for (int index = 0; index < s.length();) {
			Character ch = s.charAt(index);
			if ((index + 1) < s.length() && predMap.keySet().contains(ch) && isPred(s, index)) {
				intValue = intValue + (intMap.get(s.charAt(++index)) - intMap.get(ch));
			} else {
				intValue = intValue + intMap.get(ch);
			}	
			index++;
		}

		return intValue;
	}
	
	/*
	Leetcode#12. Integer to Roman
	Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
	*/
	public static String intToRoman(int N) {
		return convert(N, 1, new StringBuilder());
	}
	
	private static String convert(int remainingDigit, int placeValue, StringBuilder roman) {
		if(remainingDigit == 0)
			return roman.toString();
		
		int digit = remainingDigit % 10;
		if (digit != 0) {
			roman.insert(0, calculate(digit, placeValue));
		}
		
		return convert(remainingDigit / 10, placeValue * 10, roman);
	}
	
	private static String calculate(int digit, int placeValue) {
		StringBuilder builder = new StringBuilder();
		String romanDigit = romanMap.get(placeValue);
		if (digit == 4 || digit == 9) {
			builder.append(romanDigit);
			builder.append(romanMap.get((digit + 1) * placeValue));
		}
		else {
			if(digit >= 5 ) {
				digit = digit - 5;
				builder.append(romanMap.get(5 * placeValue));
			}
			
			for(int i = 0; i < digit; i++) {
				builder.append(romanDigit);
			}
		}

		return builder.toString();
	}
	
	private static boolean isPred(String s, int index) {
		for(char ch : predMap.get(s.charAt(index))) {
			if(s.charAt(index + 1) == ch)
				return true;
		}
		
		return false;
	}
	
    private static int daysOfTheCurrentYear(int day, int month, int year) {
    	int totalDays = 0;
        for(int i = 0; i < month - 1; i++) {
        	totalDays = totalDays + monthDays[i];
        }
        if(isLeapYear(year) && (month > 2))
        	totalDays++;
        
        return totalDays + day;
    }

	private static boolean isLeapYear(int year) {
		return ((year % 400) == 0) || (((year % 4) == 0) && ((year % 100) != 0));
	}
	
	private static int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static String[] days = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wenesday", "Thursday"};
	
	private static final int DEGREE_IN_A_MINUTE = 360 / 60;
	private static final int DEGREE_IN_AN_HOUR = 360 / 12;
	private static final double DEGREE_ADVANCE_PER_MIN = 30d / 60; //30 degree(1 hour) divided by 60 minutes
	
	private static Map<Character, Integer> intMap = new HashMap<>();
	private static Map<Character, List<Character>> predMap = new HashMap<>();
	static {
		intMap.put('I', 1);
		intMap.put('V', 5);
		intMap.put('X', 10);
		intMap.put('L', 50);
		intMap.put('C', 100);
		intMap.put('D', 500);
		intMap.put('M', 1000);
		
		predMap.put('I', Arrays.asList('V','X'));
		predMap.put('X', Arrays.asList('C','L'));
		predMap.put('C', Arrays.asList('D','M'));
	}
	private static Map<Integer, String> romanMap = new HashMap<>();
	static {
		romanMap.put(1, "I");
		romanMap.put(5, "V");
		romanMap.put(10, "X");
		romanMap.put(50, "L");
		romanMap.put(100, "C");
		romanMap.put(500, "D");
		romanMap.put(1000, "M");
	}
}
