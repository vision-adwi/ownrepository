package com.practice.arrays;
/*
Given a date, return the corresponding day of the week for that date.
The input is given as three integers representing the day, month and year respectively.
Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.

Example 1:
Input: day = 31, month = 8, year = 2019
Output: "Saturday"
*/
public class DayOfTheWeekDemo {
	public static void main(String[] args) {
		DaysOfTheWeek solution = new DaysOfTheWeek();
		System.out.println("13-5-2020:" + solution.dayOfTheWeek(13, 5, 2020));
	}

}

class DaysOfTheWeek {
	int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	String[] days = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wenesday", "Thursday"};

    public String dayOfTheWeek(int day, int month, int year) {
    	if(year < 1971 || year > 2100) {
    		return "";
    	}
        int yearDiff = year - 1971;
        int currentYearDays = daysOfTheCurrentYear(day, month, (year % 4) == 0);
        int leapDays = calculateLeapDays(yearDiff);
        
        int totalDays = (yearDiff * 365) + leapDays + currentYearDays;

        return days[(totalDays - 1) % 7];
    }
    
    private int daysOfTheCurrentYear(int day, int month, boolean isLeapYear) {
    	int totalDays = 0;
        for(int i = 0; i < month - 1; i++) {
        	totalDays = totalDays + monthDays[i];
        }
        if(isLeapYear && (month > 2))
        	totalDays++;
        
        return totalDays + day;
    }
    
    private int calculateLeapDays(int yearDiff) {
    	int leapDays = (yearDiff + 2) / 4;
    	
    	return leapDays;
    }
}
