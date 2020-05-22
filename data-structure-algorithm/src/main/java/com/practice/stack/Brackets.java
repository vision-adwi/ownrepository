package com.practice.stack;

import java.util.HashMap;
import java.util.Map;

public class Brackets {
	public static void main(String[] s) {
		String input = "{[(])}";
		
		System.out.println(validate(input.toCharArray()));
		
	}
	
	private static boolean validate(char[] brackets) {
		//Condition-1: Should be even 
		if((brackets.length % 2) != 0) {
			return false;
		}
		Map<Character, Character> braces = new HashMap<>();
		braces.put('{', '}');
		braces.put('[', ']');
		braces.put('(', ')');
		MyStack stack = new MyStack(brackets.length / 2);
		for(int i = 0; i < brackets.length; i++) {
			if(brackets[i] == '{' || brackets[i] == '[' || brackets[i] == '(') {
				if(!stack.isFull()) {
					stack.push(brackets[i]);
				}
				else { //Condition-2: Opening brackets should not be more than closing ones
					return false;
				}
			}
			else if(brackets[i] == '}' || brackets[i] == ']' || brackets[i] == ')') {
				if(!stack.isEmpty()) {
					if(braces.get(stack.pop()) != brackets[i]) {
						return false;
					}
				}
				else { //Condition-3: All the opening brackets has already been closed
					return false;
				}
			}
			else { //Condition-4: Input contains illegal braces
				return false;
			}
		}
		if(!stack.isEmpty()) {
			return false;
		}
		
		return true;
	}
	
    private static class MyStack {
        char[] chars;
        int top = -1;

        public MyStack(int size) {
            chars = new char[size];
        }


        public void push(char ch) {
            if( top < (chars.length - 1) ){
                chars[++top] = ch;
            }
        }

        public char pop() {
            if(top > -1) {
                return chars[top--];
            }
            return 'e';
        }

        public boolean isEmpty() {
            return top == -1;
        }
        
        public boolean isFull() {
        	return top >= chars.length - 1;
        }
    }
}
