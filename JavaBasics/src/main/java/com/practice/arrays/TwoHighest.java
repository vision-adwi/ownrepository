package com.practice.arrays;

public class TwoHighest {
	int highest = 0;
	int secondHighest = 0;

	public void findHighest(int[] values) {

		for (int value : values) {
			if (value != highest) {
				if (value > highest) {
					secondHighest = highest;
					highest = value;
				} else if (value > secondHighest) {
					secondHighest = value;
				}
			}
		}
	}
	
	public void print() {
		System.out.println("Highest: " + highest);
		System.out.println("Second Highest: " + secondHighest);
	}

	public static void main(String[] args) {
		int[] values = {23, 12, 23, 28, 27, 23, 30, 15, 35, 33, 38, 57, 40, 30, 23, 57};
		
		TwoHighest highest = new TwoHighest();
		highest.findHighest(values);
		
		highest.print();
	}

}
