package com.practice.math;
/*
Leetcode#1281. Subtract the Product and Sum of Digits of an Integer
Given an integer number n, return the difference between the product of its digits and the sum of its digits.
*/		
public class ProductSumDiff {
    public int subtractProductAndSum(int n) {
    	int product = productDigits(n, 1);
    	int sum = sumDigits(n, 0);
    	
    	return product - sum;  
    }
    
    private int sumDigits(int remainingDigits, int sum) {
    	if(remainingDigits == 0)
    		return sum;
    	
    	int digit = remainingDigits % 10;
    	return sumDigits(remainingDigits / 10, sum + digit);
    }
    
    private int productDigits(int remainingDigits, int product) {
    	if(remainingDigits == 0)
    		return product;
    	
    	int digit = remainingDigits % 10;
    	return productDigits(remainingDigits / 10, product * digit);
    }
    
    public static void main(String[] s) {
    	ProductSumDiff diff = new ProductSumDiff();
    	System.out.println(diff.subtractProductAndSum(705));
    }

}
