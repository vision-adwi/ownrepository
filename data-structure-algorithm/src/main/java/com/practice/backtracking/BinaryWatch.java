package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode#401. Binary Watch
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
Each LED represents a zero or one, with the least significant bit on the right.
*/
public class BinaryWatch {
	int[] binVal = new int[]{8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
	public List<String> readBinaryWatch(int num) {
		boolean[] setBit = new boolean[10];
		List<String> res = new ArrayList<>();
		showTime(res, setBit, num, 0, 0);
        
		return res;
    }
	
	private void showTime(List<String> res, boolean[] setBit, int num, int count, int start) {
		if(num == count) {
			String time = evaluateTime(setBit);
			System.out.println(time);
			return;
		}
		
		for(int i = start; i < setBit.length; i++) {
			if(notFeasible(setBit, i))
				continue;
			
			setBit[i] = true; count++;
			showTime(res, setBit, num, count, i + 1);
			setBit[i] = false; count--;
		}
	}
	
	private String evaluateTime(boolean[] setBit) {
		int hour = 0;
		int minutes = 0;
		for(int i = 0; i < 4; i++) {
			if(setBit[i])
				hour = hour + binVal[i];
		}
		
		for(int j = 4; j < 10; j++) {
			if(setBit[j])
				minutes = minutes + binVal[j];
		}
		
		String hr = hour == 0 ? "0" : String.valueOf(hour);
		String min;
		if(minutes == 0)
			min = "00";
		else
			min = minutes < 10 ? ("0" + String.valueOf(minutes)) : String.valueOf(minutes);
		
		return hr + ":" + min;
	}
	
	private boolean notFeasible(boolean[] setBit, int pos) {
		int hour = 0;
		int minutes = 0;
		setBit[pos] = true;
		for(int i = 0; i < 4; i++) {
			if(setBit[i])
				hour = hour + binVal[i];
		}
		
		for(int j = 4; j < 10; j++) {
			if(setBit[j])
				minutes = minutes + binVal[j];
		}
		setBit[pos] = false;
		
		return (hour > 11) || (minutes > 59);
	}
	
	public static void main(String[] s) {
		BinaryWatch watch = new BinaryWatch();
		watch.readBinaryWatch(2);
	}

}
