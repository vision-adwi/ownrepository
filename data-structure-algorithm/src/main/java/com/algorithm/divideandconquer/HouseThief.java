package com.algorithm.divideandconquer;

import com.algorithm.IHouseThief;

public class HouseThief implements IHouseThief{
	
	public long getMaxValue(int[] houses, int index) {
		if(index >= houses.length) {
			return 0L;
		}
		long choice1 = houses[index] + getMaxValue(houses, index + 2);
		long choice2 = getMaxValue(houses, index + 1);
		
		return Math.max(choice1,choice2);
	}

	@Override
	public long maxStealth(int[] wealth) {
		return getMaxValue(wealth, 0);
	}
}
