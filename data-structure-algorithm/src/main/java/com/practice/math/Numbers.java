package com.practice.math;

public class Numbers {
	/*
	Leetcode#507. Perfect Number
	We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
	Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
	Example - 28
	*/
    public static boolean checkPerfectNumber(int num) {
    	int sum = 1;
    	int i = 2;
    	while((i * i) <= num) {
    		if((num % i) == 0) {
    			sum = sum + i;
    			sum = sum + (num / i);

    			if(sum > num)
    				return false;
    		}
    		i++;
    	}
        
    	return (num != 1) && (sum == num);
    }
    
    /*
    Leetcode#202. Happy Number
    Write an algorithm to determine if a number n is "happy".
    A happy number is a number defined by the following process: Starting with any positive integer, 
    replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), 
    or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
    Return True if n is a happy number, and False if not.
    Example - 19
    */
	public static boolean isHappy(int n) {
        while(n > 9) {
            n = sumOfSquare(n, 0);
        }
        if(n == 7 || n == 1) //In single digit, only 7 is happy number. 1 is terminal condition
            return true;
        else
            return false;
        
    }
	
	/*
	Leetcode#728. Self Dividing Numbers
	A self-dividing number is a number that is divisible by every digit it contains.
	For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
	Also, a self-dividing number is not allowed to contain the digit zero.
	Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
	Example - 128
	*/
	public static boolean isSelfDiving(int number, int remainingDigits) {
		if(remainingDigits == 0)
			return true;
		
		int digit = remainingDigits % 10;
		if( (digit == 0) || (number % digit) != 0 )
			return false;

		return isSelfDiving(number, remainingDigits / 10);
	}
	

    private static int sumOfSquare(int n, int square) {
        if(n == 0)
            return square;
        
        int digit = n % 10;
        square = square + (digit * digit);
        
        return sumOfSquare(n/10, square);
    }

}
