package com.practice.slidingwindow;

public class SubstringWithBudget {
    public int equalSubstring(String s, String t, int maxCost) {
    	int[] diffs = new int[s.length()];
    	for(int k = 0; k < diffs.length; k++) {
    		diffs[k] = Math.abs(s.charAt(k) - t.charAt(k));
    	}
    	
    	int i = 0;
    	int j = 0;
    	int sum = 0;
    	int max = 0;
    	while(j < diffs.length) {
    		if((sum + diffs[j]) <= maxCost) {
    			sum = sum + diffs[j];
    			j++;
    			max = Math.max(max, (j - i));
    		}
    		else if(i < j){
    			sum = sum - diffs[i];
    			i++;
    		}
    		else {
    			i++; j++;
    		}
    	}
        
    	return max;
    }
}
