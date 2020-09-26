package com.practice.math;
/*
Leetcode#365. Water and Jug Problem
You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
*/
public class WaterJug {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z == 0)
            return true;
        if((x+y) < z)
            return false;
        if(x==0 && y==0)
            return false;
        if(x==0 && y!=0)
            return (z % y) == 0;
        if(x!=0 && y==0)
            return (z % x) == 0;

        while(x != 0) {
    		int tmp = x;
    		x = y % x;
    		y = tmp;
    	}
    	
    	return (z % y) == 0;    
    }
    
    private static int gcd(int a, int b) {
    	if(a == 0)
    		return b;
    	
    	return gcd(b%a, a);
    }
    
    public static void main(String[] s) {
    	WaterJug wj = new WaterJug();
    	System.out.println(wj.canMeasureWater(34, 5, 6));
    	
    	int a = 10, b = 15, g; 
        g = gcd(a, b); 
        System.out.println("GCD(" + a +  " , " + b+ ") = " + g); 
          
        a = 35; b = 10; 
        g = gcd(a, b); 
        System.out.println("GCD(" + a +  " , " + b+ ") = " + g); 
          
        a = 23; b = 7; 
        g = gcd(a, b); 
        System.out.println("GCD(" + a +  " , " + b+ ") = " + g);
    }

}
