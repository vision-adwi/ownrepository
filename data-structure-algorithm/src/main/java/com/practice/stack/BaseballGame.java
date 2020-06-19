package com.practice.stack;

import java.util.Stack;

/*
Leetcode#682. Baseball Game
You're now a baseball game point recorder.
Given a list of strings, each string can be one of the 4 following types:
1. Integer (one round's score): Directly represents the number of points you get in this round.
2. "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
3. "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
4. "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
Each round's operation is permanent and could have an impact on the round before and the round after.

You need to return the sum of the points you could get in all the rounds.
*/		
public class BaseballGame {
	public int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		for (String op : ops) {
			switch (op) {
			case "+": {
				int get = 0;
				int pre = 0;
				if(!stack.isEmpty()) {
					 get = stack.pop();
					 if(!stack.isEmpty()) {
						 pre = stack.peek();
					 }
					 stack.push(get);
				}
				stack.push(get + pre);
				sum = sum + stack.peek();
				break;
			}
			case "C": {
				if(!stack.isEmpty()) {
					int get = stack.pop();
					sum = sum - get;
				}
				break;
			}
			case "D": {
				int get = 0;
				if(!stack.isEmpty())
					get = stack.peek();
				stack.push(get * 2);
				sum = sum + stack.peek();
				break;
			}
			default:
				int get = Integer.parseInt(op);
				stack.push(get);
				sum = sum + stack.peek();
			}
		}

		return sum;
	}

}
