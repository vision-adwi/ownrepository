package com.practice.math;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode#1009. Complement of Base 10 Integer
Every non-negative integer N has a binary representation.  For example, 5 can be represented as "101" in binary, 
11 as "1011" in binary, and so on.  Note that except for N = 0, there are no leading zeroes in any binary representation.

The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.  
For example, the complement of "101" in binary is "010" in binary.

For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.
*/		
public class ComplementInteger {

	public static int bitwiseComplement(int N) {
		if(N == 0)
			return 1;
		
		int decimal = 0, pos = 0;
		int remaining = N;
		while(remaining != 0) {
			int bit = remaining % 2;
			decimal = decimal + ( (bit ^ 1) << pos++);
			remaining = remaining / 2;
		}
		
		return decimal;
    }
	
	private static List<Integer> toBinary(int N) {
		List<Integer> binary = new ArrayList<>();
		
		int remaining = N;
		while(remaining != 0) {
			int bit = remaining % 2;
			binary.add(0, bit);
			remaining = remaining / 2;
		}
		
		return binary;
	}
	
	private static List<Integer> getComplement(List<Integer> binary) {
		List<Integer> complement = new ArrayList<>();
		for(int i : binary) {
			if(i == 0)
				complement.add(1);
			else
				complement.add(0);
		}
		
		return complement;
	}
	
	private static int toDecimal(List<Integer> binary) {
		int decimal = 0, place = 0;
		for(int i = binary.size() - 1; i >=0; i--) {
			decimal = decimal + (binary.get(i) << place++);
		}
		
		return decimal;
	}
	
	public static void main(String[] s) {
		System.out.println(bitwiseComplement(5));
/*		System.out.println(toBinary(30));
		System.out.println(getComplement(toBinary(30)));
		System.out.println(toDecimal(toBinary(30)));*/
	}
}
