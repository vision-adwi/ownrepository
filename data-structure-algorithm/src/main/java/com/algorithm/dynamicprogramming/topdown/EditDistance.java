package com.algorithm.dynamicprogramming.topdown;

import java.util.Arrays;

import com.algorithm.IEditDistance;

public class EditDistance implements IEditDistance{
	@Override
	public int minOperations(String source, String destination) {
		int[][] mem = new int[source.length()][destination.length()];
		for(int i = 0; i < source.length(); i++) {
			Arrays.fill(mem[i], -1);
		}

		return calculateMinOperations(source, destination, 0, 0, mem);
	}
	
	public int calculateMinOperations(String source, String destination, int sIndex, int dIndex, int[][] mem) {
		if (source.length() == sIndex) {
			return destination.length() - dIndex;
		} else if (destination.length() == dIndex) {
			return source.length() - sIndex;
		} else {
			if (mem[sIndex][dIndex] == -1) {
				if (source.charAt(sIndex) == destination.charAt(dIndex)) {
					mem[sIndex][dIndex] = calculateMinOperations(source, destination, sIndex + 1, dIndex + 1, mem);
				} else {
					int o1 = calculateMinOperations(source, destination, sIndex + 1, dIndex, mem); // If insert a character
					int o2 = calculateMinOperations(source, destination, sIndex, dIndex + 1, mem); // If delete a character
					int o3 = calculateMinOperations(source, destination, sIndex + 1, dIndex + 1, mem); // If replace a character

					mem[sIndex][dIndex] = 1 + Math.min(o1, Math.min(o2, o3));
				}
			}

			return mem[sIndex][dIndex];
		}
	}
}
