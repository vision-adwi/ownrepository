package com.practice.math;
/*
Leetcode#1103. Distribute Candies to People
We distribute some number of candies, to a row of n = num_people people in the following way:
We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.
Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person, 
and so on until we give 2 * n candies to the last person.
This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until 
we run out of candies.  The last person will receive all of our remaining candies (not necessarily one more than the previous gift).
Return an array (of length num_people and sum candies) that represents the final distribution of candies.
*/
public class CandiesAndPeople {
    public int[] distributeCandies_(int candies, int num_people) {
    	int[] people = new int[num_people];
    	int repeat = 0, index = 0;
    	while(candies > 0) {
    		int toDistribute = (index + 1) + (repeat * num_people);
    		if(toDistribute > candies)
    			toDistribute = candies;
    			
    		people[index] = people[index] + toDistribute;
    		candies = candies - toDistribute;
    		index = (index + 1) % num_people;
    		if(index == 0)
    			repeat++;
    	}
    	
    	return people;
    }
    
    public int[] distributeCandies(int candies, int num) {
    	int[] people = new int[num];
    	
    	int index = 0;
    	int distribution = 0;
    	while(candies > 0) {
    		if(candies < (index + 1)) {
    			distribution = candies;
    			candies = 0;
    		}
    		else {
    			distribution = index + 1;
    			candies = candies - (index + 1);
    		}
    		people[(index % num)] = people[(index % num)] + distribution;
    		
    		index++;
    	}
    	
    	return people;
    }

}
