package com.practice.string;

public class ValidNumber {
    public boolean isNumber(String s) {
    	boolean pointUsed = false;
    	boolean expUsed = false;
    	
    	int i = 0;
    	while(i < s.length() && s.charAt(i) == ' ')
    		i++;
    	
    	if(i == s.length())
    		return false;
    	
    	if(s.charAt(i) =='+'|| s.charAt(i) == '-')
    		i++;
    	
    	char[] chars = s.substring(i).toCharArray();
    	
    	if(chars[0] == '.')
    		pointUsed = true;
    	
    	if(!firstDigitRule(chars))
    		return false;
    	
    	for(i = 1; i < chars.length; i++) {
    		if(chars[i] == '.') {
    			if(!pointRule(chars, i, pointUsed, expUsed))
    				return false;
    			
    			pointUsed = true;
    		}
    		else if(chars[i] == 'e') {
    			if(!expRule(chars, i, expUsed))
    				return false;
    			
    			expUsed = true;
    			if(chars[i + 1] == '-') {
    				i++;
    				if((i + 1) == chars.length)
    					return false;
    			}
    		}
    		else if(chars[i] >= 48 && chars[i] <= 57) {
    			continue;
    		}
    		else if(chars[i] == ' ') {
    			i++;
    			break;
    		}
    		else {
    			return false;
    		}

    	}
    	
    	while(i < chars.length && chars[i++] != ' ')
    		return false;
    	
    	return true;
        
    }
    
    private boolean pointRule(char[] chars, int idx, boolean pointUsed, boolean expUsed) {
    	if(pointUsed || expUsed || (idx + 1) == chars.length || chars[idx + 1] < 48 || chars[idx + 1] > 57) 
    		return false;
    	
    	return true;
    }
    
    private boolean expRule(char[] chars, int idx, boolean expUsed) {
    	if(expUsed || (idx + 1) == chars.length)
    		return false;
    	
    	return true;
    }
    
    private boolean firstDigitRule(char[] chars) {
    	if(chars[0] == '.' && chars.length > 1)
    		return true;
    	
    	if(chars[0] > '0' && chars[0] <= '9') {
    		return true;
    	}
    	if(chars[0] == '0') {
    		if(chars.length == 1 || chars[1] == '.')
    			return true;
    	}
    	
    	return false;
    }
    
    public static void main(String[] s) {
    	String[] numbers = new String[] {" .", " ", "0", " 0.1 ", "abc", "1 a", "2e10", " -90e3   ", " 1e", "e3", " 6e-1", " 99e2.5 ", "53.5e93", " --6 ", "-+3", "95a54e53"};
    	ValidNumber valid = new ValidNumber();
    	for(String number : numbers)
    		System.out.println(number + " : " + valid.isNumber(number));
    }
}
