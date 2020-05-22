package com.practice.arrays;

public class ThirdHighest {
	int highest = Integer.MIN_VALUE;
	int secondHighest = Integer.MIN_VALUE;
	int thirdHighest = Integer.MIN_VALUE;
	int count = 0;

	public void findHighest(int[] values) {
		for (int value : values) {
			if(count != 3) {
				if(count == 0) {
					count++;
				}
				if(count == 1 && value != highest) {
					count++;
				}
				if(count == 2 && value != highest && value != secondHighest) {
					count++;
				}
			}
			if (value != highest && value != secondHighest && value != thirdHighest) {
				if (value > highest) {
					thirdHighest = secondHighest;
					secondHighest = highest;
					highest = value;
				} else if (value > secondHighest) {
					thirdHighest = secondHighest;
					secondHighest = value;
				} else if (value > thirdHighest) {
					thirdHighest = value;
				}
			}
		}
	}
	
	private void handleFirstCondition(int value) {
		if(count == 0) {
			count++;
			return;
		}
		if(count == 1 && value != highest) {
			count++;
			return;
		}
		if(count == 2 && value != highest && value != secondHighest) {
			count++;
			return;
		}
			
	}
	
	public void print() {
		System.out.println("Highest: " + highest);
		System.out.println("Second Highest: " + secondHighest);
		System.out.println("Third Highest: " + thirdHighest);
	}

	public static void main(String[] args) {
		int[] values = {1, 2, 2, -2147483648};//23, 23, 24, 24};//, 12, 27, 23, 28, 28, 27, 23, 30, 15, 40, 35, 33, 38, 57, 40, 30, 23, 57};
		
		ThirdHighest highest = new ThirdHighest();
		highest.findHighest(values);
		
		highest.print();
	}

}
