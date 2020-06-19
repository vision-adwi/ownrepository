package com.practice.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
Leetcode#1441. Build an Array With Stack Operations
Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.

Build the target array using the following operations:

-Push: Read a new element from the beginning list, and push it in the array.
-Pop: delete the last element of the array.
If the target array is already built, stop reading more elements.
You are guaranteed that the target array is strictly increasing, only containing numbers between 1 to n inclusive.

Return the operations to build the target array.

You are guaranteed that the answer is unique.

*/
public class ArrayWithStack {

	public List<String> buildArray(int[] target, int n) {
		Stack<Integer> stack = new Stack<>();
		List<String> list = new ArrayList<>();
		int j = 0;
		for (int num = 1; num <= n; num++) {
			if (j < target.length) {
				stack.push(num);
				list.add("Push");
				if (stack.peek() != target[j]) {
					stack.pop();
					list.add("Pop");
				} else {
					j++;
				}
			}
			else {
				break;
			}
		}

		return list;
	}

}
