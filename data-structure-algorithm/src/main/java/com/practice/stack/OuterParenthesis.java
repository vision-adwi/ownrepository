package com.practice.stack;

import java.util.Stack;
/*
Leetcode#1021. Remove Outermost Parentheses
A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string 
concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty 
valid parentheses strings.
Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
*/
public class OuterParenthesis {
	public static String removeOuterParentheses(String S) {
		Stack<Character> stack = new Stack<>();
		StringBuilder builder = new StringBuilder();
		boolean flag = false;
		for(char ch : S.toCharArray()) {
			if(stack.isEmpty() && !flag) {
				flag = true;
			}
			else {
				if(ch == '(') {
					stack.push(ch);
					builder.append(ch);
				}
				else {
					if(stack.isEmpty() && flag) {
						flag = false;
					}
					else {
						stack.pop();
						builder.append(ch);
					}
				}
			}
		}
		
		return builder.toString();
        
    }
}
