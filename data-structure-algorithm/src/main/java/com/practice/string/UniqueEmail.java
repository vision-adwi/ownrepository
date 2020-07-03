package com.practice.string;

import java.util.HashSet;
import java.util.Set;

//Leetcode#929. Unique Email Addresses

public class UniqueEmail {
    public int numUniqueEmails(String[] emails) {
    	Set<String> uniqueEmails = new HashSet<String>();
    	for(String email : emails) {
    		uniqueEmails.add(normalize(email));
    	}
        
    	return uniqueEmails.size();
    }
    
    private String normalize(String s) {
        char[] chars = s.toCharArray();
        int index = 0; int newIdx = 0;
        boolean domainStarted = false;
        while(index < chars.length) {
			if (!domainStarted) {
				while (chars[index] == '.') {
					index++;
				}
				if (chars[index] == '+') {
					while (chars[index] != '@') 
						index++;
				}
				if(chars[index] == '@')
					domainStarted = true;
			}
            
            chars[newIdx++] = chars[index++];
        }
        
        return new String(chars, 0, newIdx);
    }

    public static void main(String[] s) {
    	UniqueEmail unique = new UniqueEmail();
    	System.out.println(unique.normalize("a.b.+..c@gmail.com"));
    }
}
