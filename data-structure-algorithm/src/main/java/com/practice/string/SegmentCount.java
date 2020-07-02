package com.practice.string;
/*
Leetcode#434. Number of Segments in a String
Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
Please note that the string does not contain any non-printable characters.
*/
public class SegmentCount {
    public int countSegments(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int index = 0;
        while(index < chars.length) {
            while(index < chars.length && chars[index] == ' ')
                index++;
            
            if(index < chars.length)
                count++;
                
            while(index < chars.length && chars[index++] != ' ')
                continue;
        }
        
        return count;
    }
}
