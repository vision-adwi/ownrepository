package com.practice.math;
/*
Leetcode#1323. Maximum 69 Number
Given a positive integer num consisting only of digits 6 and 9.
Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
*/
public class Max69Number {
	public int maximum69Number (int num) {
        int newNumber = num + change(num, 1, 0);
        return newNumber;
    }
	
	private int change(int remaining, int placeValue, int diff) {
		if(remaining == 0)
			return diff * (9 - 6);

		if((remaining % 10) == 6)
			diff = placeValue;
				
		return change(remaining / 10, placeValue * 10, diff);		
	}
/*	
Bitwise solution
	public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
	*/
	public static void main(String[] s) {
		Max69Number newNum = new Max69Number();
		System.out.println(newNum.maximum69Number(999));
	}

}
