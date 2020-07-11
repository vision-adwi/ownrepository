package com.algorithm.dynamicprogramming.topdown;

import com.algorithm.IHouseThief;

public class HouseThief implements IHouseThief {
	
	public long getMaxValue(long[] memory, int[] houses, int currentIndex) {
		if (currentIndex >= houses.length) {
			return 0L;
		}
		if (memory[currentIndex] == 0) {
			long choice1 = houses[currentIndex] + getMaxValue(memory, houses, currentIndex + 2);
			long choice2 = getMaxValue(memory, houses, currentIndex + 1);

			memory[currentIndex] = Math.max(choice1,choice2);
		}
		return memory[currentIndex];
	}

	@Override
	public long maxStealth(int[] wealth) {
		long[] memory = new long[wealth.length];
		
		return getMaxValue(memory, wealth, 0);
	}
}
