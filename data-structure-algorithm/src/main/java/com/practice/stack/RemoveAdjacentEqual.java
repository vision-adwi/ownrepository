package com.practice.stack;

import java.util.Stack;
/*
Leetcode#1047. Remove All Adjacent Duplicates In String
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
We repeatedly make duplicate removals on S until we no longer can.
Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
*/
public class RemoveAdjacentEqual {
	public String removeDuplicates(String S) {
		Stack<Character> stack = new Stack<>();
		for(char ch : S.toCharArray()) {
			if(stack.isEmpty()) {
				stack.push(ch);
			}
			else {
				if(stack.peek().equals(ch)) {
					stack.pop();
				}
				else {
					stack.push(ch);
				}
			}
		}
		
		char[] result = new char[stack.size()];
		for(int i = stack.size() - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}
		
		return new String(result);
        
    }

}
