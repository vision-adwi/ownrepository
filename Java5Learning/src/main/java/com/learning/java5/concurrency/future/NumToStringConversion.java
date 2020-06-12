package com.learning.java5.concurrency.future;

import java.util.Stack;

public class NumToStringConversion {
	public static String convert(int number) {
		Stack<Integer> stack = new Stack<>();
		conversion(number, stack);
		
		StringBuffer buffer = new StringBuffer();
		while(!stack.isEmpty()) {
			int digit = stack.pop();
			buffer.append(numToString(digit));
		}
		
		return buffer.toString();
	}
	
	private static void conversion(int num, Stack<Integer> stack) {
		if(num <= 0)
			return;
		
		stack.push(num % 10);
		conversion(num / 10, stack);
	}
	
	private static String numToString(int num) {
		String numStr = "Zero";
		switch (num) {
		case 1:
			numStr = "One";
			break;
		case 2:
			numStr = "Two";
			break;
		case 3:
			numStr = "Three";
			break;
		case 4:
			numStr = "Four";
			break;
		case 5:
			numStr = "Five";
			break;
		case 6:
			numStr = "Six";
			break;
		case 7:
			numStr = "Seven";
			break;
		case 8:
			numStr = "Eight";
			break;
		case 9:
			numStr = "Nine";
			break;
		case 0:
			numStr = "Zero";
			break;
		default:
			numStr = "Zero";
		}

		return numStr;
	}

}
