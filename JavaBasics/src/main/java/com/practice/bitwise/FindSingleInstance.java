package com.practice.bitwise;
/*
To find the single instance of number in the group of numbers where
all numbers are present in pairs. 
*/
public class FindSingleInstance {

	public static void main(String[] args) {
		int[] numbers = {18, 14, 5, 19, 34, 14, 18, 34, 5}; //Only 19 is the number with single instance
		int result = numbers[0];
		for(int i = 1; i < numbers.length; i++) {
			result = result ^ numbers[i];
		}

		System.out.println("Result - " + result);
	}

}
