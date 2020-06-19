package com.practice.stack;

import java.util.Stack;
/*
Leetcode#844. Backspace String Compare
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
Note that after backspacing an empty text, the text will continue empty.
*/
public class BackspaceString {
    public boolean backspaceCompare(String S, String T) {
    	Stack<Character> SStack = new Stack<>();
    	Stack<Character> TStack = new Stack<>();
    	
		for (Character ch : S.toCharArray()) {
			if (ch == '#') {
				if(!SStack.isEmpty())
					SStack.pop();
			}
			else {
				SStack.push(ch);
			}
		}
    	
    	for(Character ch : T.toCharArray()) {
    		if (ch == '#') {
    			if(!TStack.isEmpty())
    				TStack.pop();
    		}
			else {
				TStack.push(ch);
			}
    	}
    	
    	if(SStack.size() != TStack.size())
    		return false;
    	
    	while(!SStack.isEmpty()) {
    		if(SStack.pop() != TStack.pop())
    			return false;
    	}
    	
    	return true;     
    }
}
