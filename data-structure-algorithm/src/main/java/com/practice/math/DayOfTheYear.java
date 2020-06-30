package com.practice.math;
/*
Leetcode#1154. Day of the Year
Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.
*/		
public class DayOfTheYear {
	public static int dayOfYear(String date) {
		String[] ymd = date.split("-");
		return daysOfTheCurrentYear(Integer.parseInt(ymd[2]), Integer.parseInt(ymd[1]), 
				(isLeapYear(Integer.parseInt(ymd[0]))));
    }
	
	private static int daysOfTheCurrentYear(int day, int month, boolean isLeapYear) {
    	int totalDays = 0;
        for(int i = 0; i < month - 1; i++) {
        	totalDays = totalDays + monthDays[i];
        }
        if(isLeapYear && (month > 2))
        	totalDays++;
        
        return totalDays + day;
    }
	
	public static boolean isLeapYear(int year) {
		return ((year % 400) == 0) || (((year % 4) == 0) && ((year % 100) != 0));
	}
	
	public static void main(String[] s) {
		System.out.println(dayOfYear("2004-03-01"));
	}
	
	static int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

}
