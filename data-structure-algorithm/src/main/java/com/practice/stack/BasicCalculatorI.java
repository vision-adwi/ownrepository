package com.practice.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
Leetcode#224. Basic Calculator
Implement a basic calculator to evaluate a simple expression string.
The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
*/
public class BasicCalculatorI {
	public static void main(String[] s) {
		BasicCalculatorI calculator = new BasicCalculatorI();
		System.out.println(calculator.calculate("2-4-(8+2-6+(8+4-(1)+8-10))"));
	}
	public int calculate(String s) {
		List<String> tokenized = tokenize(s);
		Stack<String> expression = new Stack<>();
		
		for(String what : tokenized) {
			if(")".equals(what)) {
				Stack<String> miniOp = new Stack<>();
				while (true) {
					if(expression.peek().equals("(")) {
						expression.pop();
						expression.push(evalStack(miniOp));
						break;
					}
					miniOp.push(expression.pop());
				}	
			}
			else {
				expression.push(what);
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
	
	private String evalStack(Stack<String> theStack) {
		String op1 = theStack.pop();
		while(!theStack.isEmpty()) {
			String operator = theStack.pop();
			String op2 = theStack.pop();
			op1 = eval(op1, operator, op2);
		}
		
		return String.valueOf(op1);
	}
	
	private String eval(String op1, String operator, String op2) {
		int operand1 = Integer.parseInt(op1);
		int operand2 = Integer.parseInt(op2);
		if(operator.equals("+")) {
			return String.valueOf((operand1 + operand2));
		}
		else {
			return String.valueOf((operand1 - operand2));
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



}
