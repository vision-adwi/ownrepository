package com.algorithm.dynamicprogramming.bottomup;

import com.algorithm.IHouseThief;

public class HouseThief implements IHouseThief{
	@Override
	public long maxStealth(int[] wealth) {
		int[] memory = new int[wealth.length + 2];
		memory[wealth.length] = memory[wealth.length + 1] = 0;
		
		for(int i = wealth.length - 1; i >= 0; i--) {
			memory[i] = Math.max(wealth[i] + memory[i + 2], memory[i + 1]);
		}
		
		return memory[0];
	}
}
