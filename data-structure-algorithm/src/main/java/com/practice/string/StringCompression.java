package com.practice.string;

public class StringCompression {
    public int compress(char[] chars) {
        char next;
        int index = 0, targetIndex = 0, count = 0;
        while(index < chars.length) {
            count = 1;
            chars[targetIndex++] = chars[index];
            next = chars[index++];
            
            while(index < chars.length && chars[index] == next) {
                index++;
                count++;
            }
			if (count > 1) {
				int startIndex = targetIndex;
				while (count > 0) {
					chars[targetIndex++] = (char) ((count % 10) + 48);
					count = count / 10;
				}
			}
        }
        
        return targetIndex;
    }
}
