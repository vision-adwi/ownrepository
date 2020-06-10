package com.practice.bitwise;

public class BitwiseOperations {
	public static void main(String[] s) {
		int value1 = 0b00000000000000000000000000000011;
		int value2 = 0b00000000000000000000000000000010;
		
		System.out.println("value1        		: " + value1);
		System.out.println("value2        		: " + value2);
		System.out.println("~value1       		: " + ~value1);
		System.out.println("value1 & value2		: " + (value1 & value2) + "    " + Integer.toBinaryString(value1 & value2));
		System.out.println("value1 | value2		: " + (value1 | value2) + "    " + Integer.toBinaryString(value1 | value2));
		System.out.println("value1 ^ value2		: " + (value1 ^ value2) + "    " + Integer.toBinaryString(value1 ^ value2));
		System.out.println("value1 << 1    		: " + (value1 << 1) + "    " + Integer.toBinaryString(value1 << 1));
		System.out.println("value1 >> 1    		: " + (value1 >> 1) + "    " + Integer.toBinaryString(value1 >> 1));
		System.out.println("value1 >>> 1   		: " + (value1 >>> 1) + "    " + Integer.toBinaryString(value1 >>> 1));
		//System.out.println(((value1 >> 1) >> 1) + "   " + Integer.toBinaryString(((value1 >> 1) >> 1)));
		System.out.println((555 % 15) + " " + (555 & 14));
		System.out.println((49 % 4) + " " + (49 & 3));
		System.out.println((59 % 4) + " " + (59 & 3));
	}

}
