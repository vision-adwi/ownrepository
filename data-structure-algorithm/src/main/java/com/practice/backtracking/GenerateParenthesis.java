package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode#22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
*/
public class GenerateParenthesis {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
        generate(n*2, n, new StringBuilder(), result);
		return result;
    }
	
	private void generate(int length, int remaining, StringBuilder builder, List<String> result) {
		if(builder.length() == length) {
			result.add(builder.toString());
			return;
		}
		
		String parenthesis = "()";
		for(char paren : parenthesis.toCharArray()) {
			if(isValid(paren, remaining, length - builder.length()))
				continue;
			
			if(paren == '(')
				remaining = remaining - 1;
			
			builder.append(paren);
			generate(length, remaining, builder, result);
			if(builder.charAt(builder.length() - 1) == '(')
				remaining++;
			builder.setLength(builder.length() - 1);
		}
		
	}
	
	private boolean isValid(char parenthesis, int remaining, int remainingSize) {
		if((parenthesis == '(') && (remaining == 0))
			return true;
		
		if((parenthesis == ')') && (remaining*2) >= remainingSize)
			return true;
		
		return false;
	}
	
	public static void main(String[] s) {
		GenerateParenthesis parenthesis = new GenerateParenthesis();
		parenthesis.generateParenthesis(0);
		System.out.println(parenthesis.generateParenthesis(3));
	}

}
