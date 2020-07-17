package com.practice.array;

import java.util.stream.IntStream;
/*
Leetcode#1375. Bulb Switcher III
There is a room with n bulbs, numbered from 1 to n, arranged in a row from left to right. Initially, all the bulbs are turned off.
At moment k (for k from 0 to n - 1), we turn on the light[k] bulb. A bulb change color to blue only if it is on and all the previous bulbs (to the left) are turned on too.
Return the number of moments in which all turned on bulbs are blue.
*/
public class BulbSwitcher {
	public int numTimesAllBlue(int[] light) {
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

}
