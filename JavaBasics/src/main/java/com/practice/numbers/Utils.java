package com.practice.numbers;

public class Utils {
	public static double perimeterOfCircle(double radius) {
		return Math.PI * radius * 2;
	}
	
	public static double areaOfCircle(double radius) {
		return Math.PI * radius * radius;
	}
	
	public static boolean isLeapYear(int year) {
		return ((year % 400) == 0) || (((year % 4) == 0) && ((year % 100) != 0));
	}
	
	public static double centiToFaren(double centigrade) {
		return (centigrade * 1.8) + 32;
	}
	
	public static double farenToCenti(double farenhite) {
		return (farenhite - 32) / 1.8;
	}
	
	//Without using % operator
	public static boolean isEven(int number) {
		return ( (number / 2) * 2) == number;
	}
	
	public static void swap(int a, int b) {
		System.out.println("a = " + a + " b = " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a = " + a + " b = " + b);
	}
	
	public static int findMissingNumber(int[] arr) {
		int n = arr.length + 1;
		int seriesTotal = (n * (n + 1)) / 2;
		for(int i : arr) {
			seriesTotal = seriesTotal - i;
		}
		
		return seriesTotal;
	}
	
	public static void floydTriangle(int max) {
		int limit = 1;
		int line_breaker = limit;
		
		int num = 1;
		while(num <= max) {
			System.out.printf("%3s", num++);
			--line_breaker;
			
			if(line_breaker == 0) {
				System.out.println();
				line_breaker = ++limit;
			}
		}
	}
	
	public static void main(String... s) {
		//swap(215654565, 7);
		//System.out.println(findMissingNumber(new int[]{1,2,3,4,5,6,8,9}));
		floydTriangle(99);
		//System.out.println("50 - " + isEven(50));
		//System.out.println("75 - " + isEven(75));
	}

}
