package com.practice.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
Leetcode#227. Basic Calculator II
Implement a basic calculator to evaluate a simple expression string.
The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
*/
public class BasicCalculatorII {
	public int calculate(String s) {
		List<String> tokenized = tokenize(s);
		Stack<String> expression = new Stack<>();

		for(int i = 0; i < tokenized.size();) {
			if(tokenized.get(i).equals("*") || tokenized.get(i).equals("/")) {
				String op1 = expression.pop();
				String operator = tokenized.get(i++);
				String op2 = tokenized.get(i++);
				
				expression.push(eval(op1, operator, op2));
			}
			else {
				expression.push(tokenized.get(i++));
			}
		}
		
		String op1 = expression.get(0);
		for(int i = 1; i < expression.size();) {
			String operator = expression.get(i++);
			String op2 = expression.get(i++);
			op1 = eval(op1, operator, op2);
		}

		return Integer.parseInt(op1);
    }
	
	private String eval(String op1, String operator, String op2) {
		int operand1 = Integer.parseInt(op1);
		int operand2 = Integer.parseInt(op2);
		switch (operator) {
		case "+":
			return String.valueOf(operand1 + operand2);
		case "-":
			return String.valueOf(operand1 - operand2);
		case "*":
			return String.valueOf(operand1 * operand2);
		case "/":
			return String.valueOf(operand1 / operand2);
		default: return "";
		}
	}
	
	private List<String> tokenize(String s) {
		List<String> tokenized = new ArrayList<>();
		for(int i = 0; i < s.length();) {
			while(i < s.length() && Character.isWhitespace(s.charAt(i)))
				i++;
			
			if(i == s.length())
				break;
			
			if(Character.isDigit(s.charAt(i))) {
				int j = i++;
				while(i < s.length() && Character.isDigit(s.charAt(i))) {
					i++;
				}
				tokenized.add(s.substring(j, i));
			}
			else {
				tokenized.add(String.valueOf(s.charAt(i++)));
			}
		}
		
		return tokenized;
	}
	
	public static void main(String[] s) {
		BasicCalculatorII calculator = new BasicCalculatorII();
		System.out.println(calculator.calculate("3*17+11*3"));
	}

}
