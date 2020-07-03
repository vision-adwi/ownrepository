package com.practice.string;

import java.util.HashSet;
import java.util.Set;

//Leetcode#804. Unique Morse Code Words

public class MorseCodes {
	String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
	                   "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
	                   "..-","...-",".--","-..-","-.--","--.."};
	
    public int uniqueMorseRepresentations(String[] words) {
    	Set<String> unique = new HashSet<>();
    	
    	StringBuilder builder;
        for(String word : words) {  	
        	builder = new StringBuilder();
        	for(char aChar : word.toCharArray()) {
        		String code = codes[aChar - 97];
        		builder.append(code);
        	}
        	unique.add(builder.toString());
        }
        
        return unique.size();
    }
}
