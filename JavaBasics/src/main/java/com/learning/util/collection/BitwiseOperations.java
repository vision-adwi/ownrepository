package com.learning.util.collection;

public class BitwiseOperations {
	public static void main(String[] s) {
		int value  = 0b00000000000000000000000000000011;
		int value2 = 0b00000000000000000000000000000010;
		
		System.out.println("value         : " + value);
		System.out.println("value2        : " + value2);
		System.out.println("~value        : " + ~value);
		System.out.println("value & value2: " + (value & value2) + "    " + Integer.toBinaryString(value & value2));
		System.out.println("value | value2: " + (value | value2) + "    " + Integer.toBinaryString(value | value2));
		System.out.println("value ^ value2: " + (value ^ value2) + "    " + Integer.toBinaryString(value ^ value2));
		System.out.println("value << 1    : " + (value << 1) + "    " + Integer.toBinaryString(value << 1));
		System.out.println("value >> 1    : " + (value >> 1) + "    " + Integer.toBinaryString(value >> 1));
		System.out.println("value >>> 1   : " + (value >>> 1) + "    " + Integer.toBinaryString(value >>> 1));
		System.out.println(((value >> 1) >> 1) + "   " + Integer.toBinaryString(((value >> 1) >> 1)));
	}

}
