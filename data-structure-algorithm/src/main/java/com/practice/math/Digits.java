package com.practice.math;

public class Digits {
	/*
	Leetcode# 7. Reverse Integer
	*/
	public static int reverse(int x) {
        return reverseAll(x, 0);
    }
	
	/*
	Leetcode# 258. Add Digits
	Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
	*/
	public static int addDigits(int num) {
		while (num > 9) {
			num = sumDigits(num, 0);
		}

		return num;
	}

	/*
	Leetcode#1281. Subtract the Product and Sum of Digits of an Integer
	Given an integer number n, return the difference between the product of its digits and the sum of its digits.
	*/	
    public static int subtractProductAndSum(int n) {
    	return diffProdSum(n, 1, 0);  
    }
    
    /*
    Leetcode#1295. Find Numbers with Even Number of Digits
    */
    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums) {
            if((num != 0) && ((digitCount(num, 0) % 2) == 0))
                count++;
        }
        return count;
    }
    
    /*
    Leetcode#204. Count Primes
    Count the number of prime numbers less than a non-negative number, n.
    */
    public int countPrimes(int n) {
    	boolean[] primes = new boolean[n];
    	for(int i = 2; i < primes.length; i++)
    		primes[i] = true;
    	
    	for(int k = 2; k * k < n; k++) {
    		if(primes[k]) {
    			for(int j = k * k; j < n; j+=k) {
    				primes[j] = false;
    			}
    		}
    	}
    	
    	int count = 0;
    	for(int i = 0; i < primes.length; i++) {
    		if(primes[i])
    			count++;
    	}
    	
    	return count;
    }
    
    private static int digitCount(int dividend, int digits) {
		if(dividend == 0) {
			return digits;
		}
		
		return digitCount(dividend / 10, digits + 1);
	}

	private static int reverseAll(int n, int reverse) {
		if(n == 0)
			return reverse;
		
		if(reverse > (Integer.MAX_VALUE / 10) || reverse < (Integer.MIN_VALUE / 10)) //to handle overflow
			reverse = 0;
		else
			reverse = (reverse * 10) + (n % 10);
		
		return reverseAll(n / 10, reverse);
	}
	
	private static int sumDigits(int remainingDigits, int sum) {
		if (remainingDigits == 0)
			return sum;

		int digit = remainingDigits % 10;
		return sumDigits(remainingDigits / 10, sum + digit);
	}

    private static int diffProdSum(int remainingDigits, int product, int sum) {
    	if(remainingDigits == 0)
    		return product - sum;
    	
    	int digit = remainingDigits % 10;
    	return diffProdSum(remainingDigits / 10, product * digit, sum + digit);
    }

}
