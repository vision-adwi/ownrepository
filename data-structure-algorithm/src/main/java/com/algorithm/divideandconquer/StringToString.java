package com.algorithm.divideandconquer;

import com.algorithm.IStringToString;

public class StringToString implements IStringToString{
	@Override
	public int minOperations(String source, String destination) {
		return calculateMinOperations(source, destination, 0, 0);
	}
	
	public int calculateMinOperations(String source, String destination, int sIndex, int dIndex) {
		if (source.length() == sIndex) {
			return destination.length() - dIndex;
		}
		else if (destination.length() == dIndex) {
			return source.length() - sIndex;
		}
		else if (source.charAt(sIndex) == destination.charAt(dIndex)) {
			return calculateMinOperations(source, destination, sIndex + 1, dIndex + 1);
		}
		else {
			int o1 = calculateMinOperations(source, destination, sIndex + 1, dIndex); //If insert a character
			int o2 = calculateMinOperations(source, destination, sIndex, dIndex + 1); //If delete a character
			int o3 = calculateMinOperations(source, destination, sIndex + 1, dIndex + 1); //If replace a character
		
			return 1 + Math.min(o1, Math.min(o2, o3));
		}
	}
}
