package com.practice.math;
/*
Leetcode#171. Excel Sheet Column Number
Given a column title as appear in an Excel sheet, return its corresponding column number.
*/		
public class ExcelSheetColumn {
	public static int titleToNumber(String s) {
		byte[] bytes = s.getBytes();
		
		int sum = 0;
		int pos = bytes.length - 1;
		for(int i = pos; i >= 0; i--) {
			int product = 1;
			for(int j = 0; j < (pos - i); j++) {
				product = product * 26;
			}

			sum = sum + (product * (bytes[i] - 64));
		}
        
		return sum;
    }
	public static void main(String[] s) {
		System.out.println(titleToNumber("ZY"));
	}

}
