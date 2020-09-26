package com.practice.slidingwindow;
/*
Leetcode#1052. Grumpy Bookstore Owner
Today, the bookstore owner has a store open for customers.length minutes.  Every minute, some number of customers (customers[i]) enter the store, 
and all those customers leave after the end of that minute.

On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  
When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.

The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.
Return the maximum number of customers that can be satisfied throughout the day.
*/
public class GrumpyStores {
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int i = 0, j = 0;
		
		int max = Integer.MIN_VALUE;
		int window = 0;
		int total = 0;
		int disatisfied = 0;
		while(j < customers.length) {
			total += customers[j];
			disatisfied += customers[j] * grumpy[j];
			
			window += customers[j] * grumpy[j];
			if(j >= X) {
				window -= customers[i] * grumpy[i];
				i++;
			}
			
			max = Math.max(max, window);
			j++;
		}
		
		return (total - disatisfied + max);
	}
	
    public int maxSatisfied_(int[] customers, int[] grumpy, int X) {
    	int i = 0, j = 0;
    	int unsatisfied_window = 0;
    	int unsatisfied_window_max = 0;
    	int satisfied_customers = 0;
    	while(j < customers.length) {
    		X--;
    		if(X < 0) {
    			if(grumpy[i] == 1) {
    				unsatisfied_window = unsatisfied_window - customers[i];	
    			}
    			i++;
    		}
    		
			if (grumpy[j] == 1) {
				unsatisfied_window = unsatisfied_window + customers[j];
				unsatisfied_window_max = Math.max(unsatisfied_window_max, unsatisfied_window);
			}

    		if(grumpy[j] == 0)
    			satisfied_customers = satisfied_customers + customers[j];

    		j++;    		
    	}
    	
    	return satisfied_customers + unsatisfied_window_max;    
    }
    
    public static void main(String[] s) {
    	GrumpyStores stores = new GrumpyStores();
    	System.out.println(stores.maxSatisfied(new int[] {2,6,6,9}, new int[] {0,0,1,1}, 1));
    }

}
