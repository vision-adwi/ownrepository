package com.practice.array;
/*
Leetcode#42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
*/
public class TrappingRainWater {
    public int trap(int[] height) {
        int len = height.length;
        int[] leftTop = new int[len];
        int[] rightTop = new int[len];

        for(int i = 1; i < len; i++) {
            leftTop[i] = Math.max(leftTop[i - 1], height[i - 1]);
        }

        for(int j = len - 2; j >= 0; j--) {
            rightTop[j] = Math.max(rightTop[j + 1], height[j + 1]);
        }
        
        int trappedWater = 0;
        for(int k = 0; k < len; k++) {
            int boundary = Math.min(leftTop[k], rightTop[k]);
            if(boundary > height[k])
                trappedWater = trappedWater + (boundary - height[k]);
        }
        
        return trappedWater;
    }
    
    public static void main(String[] s) {
    	TrappingRainWater trapWater = new TrappingRainWater();
    	System.out.println(trapWater.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }

}
