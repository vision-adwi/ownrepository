package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
Leetcode#1291. Sequential Digits
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
*/
public class SequentialDigits {
	public List<Integer> sequentialDigits(int low, int high) {
		List<Integer> result = new ArrayList<>();
		find(1, 0, low, high, result);
		Collections.sort(result);
		return result;
    }
	
	private void find(int next, int number, int low, int high, List<Integer> result) {
		if(number > high)
			return;
		
		if(number >= low && number <= high) {
			result.add(number);
			System.out.println(number);
		}

		for(int i = next; i <= 9; i++) {
			if((number == 0) || (number % 10) == (i - 1)) {
				find((i + 1), ((number * 10) + i), low, high, result);
			}
		}
	}
	
	public static void main(String[] s) {
		SequentialDigits digits = new SequentialDigits();
		digits.sequentialDigits(1000, 13000);
	}

}
