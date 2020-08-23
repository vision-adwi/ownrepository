package com.practice.string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> result = new ArrayList<>();
    	List<StringBuilder> builders;
    	
    	int i = -1;
    	while(i < words.length - 1) {
    		int count = 0;
    		builders = new ArrayList<>();
    		StringBuilder builder = null;
    		while(i < words.length - 1 && count < maxWidth) {
    			int tmpCount = words[i + 1].length() + count;
    			if(builder != null)
    				tmpCount++;
    			if(tmpCount <= maxWidth) {
    				if(builder != null) {
    					builder.append(' ');
    				}
    				
    				builder = new StringBuilder(words[i + 1]);
    				builders.add(builder);
    				count = tmpCount;
    				i++;
    			}
    			else {
    				break;
    			}
    		}
    		
    		while(i < words.length - 1 && count < maxWidth) {
    			builder = null;
    			for(int k = 0; k < builders.size() && count < maxWidth; k++) {
    				if(builder != null) {
    					builder.append(' ');
    					count++;
    				}
    				
    				builder = builders.get(k);	
    			}
    		}
    		
    		
    		
    		StringBuilder tmp = new StringBuilder();
    		for(StringBuilder buil : builders) {
    			tmp.append(buil);
    		}
    		
    		if(i >= words.length - 1) {
    			while(count < maxWidth) {
    				tmp.append(' ');
    				count++;
    			}
    		}
    		
    		result.add(tmp.toString()); 
    	}
        
    	
    	return result;
    }
    
    public static void main(String[] s) {
    	String[] input = {"This", "is", "an", "example", "of", "text", "justification."};
    	TextJustification just = new TextJustification();
    	System.out.println(just.fullJustify(input, 16));
    }
}
