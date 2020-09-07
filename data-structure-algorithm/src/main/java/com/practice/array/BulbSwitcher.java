package com.practice.array;

import java.util.stream.IntStream;
/*
Leetcode#1375. Bulb Switcher III
There is a room with n bulbs, numbered from 1 to n, arranged in a row from left to right. Initially, all the bulbs are turned off.
At moment k (for k from 0 to n - 1), we turn on the light[k] bulb. A bulb change color to blue only if it is on and all the previous bulbs (to the left) are turned on too.
Return the number of moments in which all turned on bulbs are blue.
*/
public class BulbSwitcher {
	public int numTimesAllBlue_(int[] light) {
		int size = IntStream.of(light)
				.max().getAsInt();
		
		boolean[] bulbs = new boolean[size];
		int next = 0; int highest = 0;
		int count = 0;
		
		for(int moment : light) {
			bulbs[moment - 1] = true;
			if(moment > highest)
				highest = moment;
			while(next < bulbs.length && bulbs[next])
				next++;
			
			if(next == highest)
				count++;
		}
        
		return count;
    }
	
	public int numTimesAllBlue(int[] light) {
		int len = light.length;

		boolean[] on = new boolean[len];
		int count = 0, incidents = 0, pivot = 0;
		for (int i = 0; i < len; i++) {
			count++;
			on[light[i] - 1] = true;
			if (pivot == (light[i] - 1)) {
				while (pivot < len && on[pivot])
					pivot++;
			}

			if (pivot == count)
				incidents++;
		}

		return incidents;
	}

	public static void main(String[] s) {
		BulbSwitcher switcher = new BulbSwitcher();
		switcher.numTimesAllBlue(new int[] {2, 1, 3, 5, 4});
	}
}
