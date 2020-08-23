package com.practice.string;
/*
Leetcode#434. Number of Segments in a String
Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
Please note that the string does not contain any non-printable characters.
*/
public class SegmentCount {
    public int countSegments(String s) {
        int count = 0, index = 0;
        while(true) {
            while(index < s.length() && s.charAt(index) == ' ')
                index++;
            
            if(index >= s.length())
            	break;
   
            while(index < s.length() && s.charAt(index) != ' ')
            	index++;
            
            count++;
        }
        
        return count;
    }
    
    public static void main(String[] s) {
    	SegmentCount segmentCount = new SegmentCount();
    	System.out.println(segmentCount.countSegments("    There are   so many words   "));
    }
}
