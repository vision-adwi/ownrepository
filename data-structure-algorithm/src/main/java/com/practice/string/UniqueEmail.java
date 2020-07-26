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
        int sourceIndex = 0; int targetIndex = 0;
        boolean domainStarted = false;
        while(sourceIndex < chars.length) {
			if (!domainStarted) {
				while (chars[sourceIndex] == '.') {
					sourceIndex++;
				}
				if (chars[sourceIndex] == '+') {
					while (chars[sourceIndex] != '@') 
						sourceIndex++;
				}
				if(chars[sourceIndex] == '@')
					domainStarted = true;
			}
            
            chars[targetIndex++] = chars[sourceIndex++];
        }

        return new String(chars, 0, targetIndex);
    }

    public static void main(String[] s) {
    	UniqueEmail unique = new UniqueEmail();
    	System.out.println(unique.normalize("a.b.+..c@gmail.com"));
    }
}
