package com.practice.array;

import java.util.Arrays;
/*
Leetcode#283. Move Zeroes
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
*/
public class MovesZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while(j < nums.length) {
            while(j < nums.length && nums[j] == 0)
                j++;
            
            if(j == nums.length)
                break;
            
            nums[i++] = nums[j++];
        }
        
        Arrays.fill(nums, i, j, 0);        
    }
    
    public static void main(String[] s) {
    	MovesZeroes zeroes = new MovesZeroes();
    	zeroes.moveZeroes(new int[] {0,1,0,3,12});
    	//System.out.println();
    	
    }

}
