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
    public int[] distributeCandies(int candies, int num_people) {
    	int[] people = new int[num_people];
    	
    	int rem_candies = candies;
    	int n = num_people;
    	int candy = 1;
    	for(int i = 0; i < n; i++) {
    		if(rem_candies <= candy) {
    			people[i] = people[i] + rem_candies;
    			break;
    		}
    			
    		people[i] = people[i] + candy;
    		rem_candies = rem_candies - candy++;
    		
    		if(i == (n-1))
    			i = -1;
    	}
    	
    	return people;
        
    }

}
