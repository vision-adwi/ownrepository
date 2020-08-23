package com.practice.string;

public class BuddyString {
    public boolean buddyStrings(String A, String B) {
    	if(A.length() != B.length())
    		return false;
    	
    	int i = 0, count = 0;
    	int first = -1, second = -1;
    	while(true) {
    		if(i < A.length() && (A.charAt(i) == B.charAt(i)))
    			i++;
    		
    		if(i >= A.length()) {
    			if(count == 1)
    				return false;
    			else
    				break;
    		}

    		count++;
    		if(count > 2)
    			return false;
    		
    		if(first == -1)
    			first = i;
    		else
    			second = i;
    	}
        
    	return (A.charAt(first) == B.charAt(second)) && (A.charAt(second) == B.charAt(first));
    }
    
    public static void main(String[] s) {
    	BuddyString buddy = new BuddyString();
    	buddy.buddyStrings("ba", "ab");
    }

}
