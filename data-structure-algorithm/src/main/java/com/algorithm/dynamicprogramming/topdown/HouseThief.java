package com.algorithm.dynamicprogramming.topdown;

import com.algorithm.IHouseThief;

public class HouseThief implements IHouseThief {
	
	public int getMaxValue(int[] memory, int[] houses, int currentIndex) {
		if (currentIndex >= houses.length) {
			return 0;
		}
		if (memory[currentIndex] == 0) {
			int choice1 = houses[currentIndex] + getMaxValue(memory, houses, currentIndex + 2);
			int choice2 = getMaxValue(memory, houses, currentIndex + 1);

			memory[currentIndex] = (choice1 > choice2) ? choice1 : choice2;
		}
		return memory[currentIndex];
	}

	@Override
	public long maxStealth(int[] wealth) {
		int[] memory = new int[wealth.length];
		
		return getMaxValue(memory, wealth, 0);
	}
}
