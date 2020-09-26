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
		List<String> res = new ArrayList<>();
		showTime(res, new boolean[10], num, 0);
        
		return res;
    }
	
	private void showTime(List<String> res, boolean[] setBit, int count, int start) {
		if(count == 0) {
			String time = evaluateTime(setBit);
			if(!time.equalsIgnoreCase("-1")) {
				System.out.println(time);
				res.add(time);
			}
			return;
		}
		
		for(int i = start; i < setBit.length; i++) {
			setBit[i] = true; 
			showTime(res, setBit, count - 1, i + 1);
			setBit[i] = false; 
		}
	}
	
	private String evaluateTime(boolean[] setBit) {
		int hour = 0;
		int minutes = 0;
		
		int i = 0;
		while(i < 4) {
			if(setBit[i])
				hour = hour + binVal[i];
			i++;
		}
		while(i < 10) {
			if(setBit[i])
				minutes = minutes + binVal[i];
			i++;
		}
		
		if(hour > 11 || minutes > 59)
			return "-1";

		String hr = hour == 0 ? "0" : String.valueOf(hour);
		String min;
		if(minutes == 0)
			min = "00";
		else
			min = minutes < 10 ? ("0" + String.valueOf(minutes)) : String.valueOf(minutes);
		
		return hr + ":" + min;
	}

	public static void main(String[] s) {
		BinaryWatch watch = new BinaryWatch();
		watch.readBinaryWatch(2);
	}
}
