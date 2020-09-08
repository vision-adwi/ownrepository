package com.practice.array;

import java.util.LinkedList;
/*
Leetcode#84. Largest Rectangle in Histogram
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.
*/
public class LargestRectangleHistogram {
	public int largestRectangleArea(int[] heights) {
		LinkedList<Integer> position = new LinkedList<>();
		LinkedList<Integer> height = new LinkedList<>();

		int i = 0;
		int maxHeight = 0;
		while (i < heights.length) {
			if (position.isEmpty() || height.peek() < heights[i]) {
				position.push(i);
				height.push(heights[i]);
			} else {
				int pos = -1;
				while (!height.isEmpty() && height.peek() >= heights[i]) {
					pos = position.pop();
					maxHeight = Math.max(maxHeight, height.pop() * (i - pos));
				}

				position.push(pos);
				height.push(heights[i]);
			}

			i++;
		}

		while (!height.isEmpty()) {
			maxHeight = Math.max(maxHeight, height.pop() * (i - position.pop()));
		}

		return maxHeight;
	}

}
