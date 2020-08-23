package com.practice.diviceandconquer;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
	public int numDecodings(String s) {
		return decodeIt(s, new HashMap<>());
	}
	
	public int decodeIt(String s, Map<String, Integer> mem) {
		if (!mem.containsKey(s)) {
			int count = 0;
			if (!s.isEmpty() && !s.startsWith("0")) {
				if ((s.length() <= 2) && Integer.parseInt(s) >= 1 && Integer.parseInt(s) <= 26) {
					count++;
				}

				for (int i = 1; i <= s.length() && i <= 2; i++) {
					int num = Integer.parseInt(s.substring(0, i));
					if (num >= 1 && num <= 26) {
						count += decodeIt(s.substring(i), mem);
					}
				}
			}
			mem.put(s, count);
		}

		return mem.get(s);
	}

}
