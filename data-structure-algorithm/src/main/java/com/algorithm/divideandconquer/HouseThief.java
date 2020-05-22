package com.algorithm.divideandconquer;

import com.algorithm.IHouseThief;

public class HouseThief implements IHouseThief{
	
	public int getMaxValue(int[] houses, int start) {
		if(start >= houses.length) {
			return 0;
		}
		int choice1 = houses[start] + getMaxValue(houses, start + 2);
		int choice2 = getMaxValue(houses, start + 1);
		
		return (choice1 > choice2) ? choice1 : choice2;
	}

	@Override
	public long maxStealth(int[] wealth) {
		return getMaxValue(wealth, 0);
	}
}
