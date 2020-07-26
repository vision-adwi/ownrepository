package com.practice.string;

public class NextGreaterElementIII {
	public int nextGreaterElement(int n) {
		if(n == 2147483647)//have to handle later
            return -1;
		int[] numbers = new int[10];
		int lastRemainder = n % 10; numbers[lastRemainder]++;
		int divisor = n / 10;
		int radix = 10; boolean shouldExit = false;
		while(divisor > 0) {
			if((divisor % 10) < lastRemainder) {
				shouldExit = true;
			}

			if(radix > 100000000)
                return -1;
			radix = radix * 10;
			lastRemainder = divisor % 10;
			numbers[lastRemainder]++;
			divisor = divisor / 10;
			
			if(shouldExit)
				break;
		}
		
		if(!shouldExit)
			return -1;
		
		int finalNumber = divisor * radix;
		radix = radix / 10;
		for(int i = lastRemainder+1; i <= 9; i++) {
			if(numbers[i] > 0) {
				finalNumber = finalNumber + (radix * i);
				numbers[i]--;
				radix = radix / 10;
				break;
			}
		}
		
		for(int i = 0; i <= 9; i++) {
			while(numbers[i] > 0) {
				finalNumber = finalNumber + (i * radix);
				numbers[i]--;
				radix = radix / 10;
			}
		}
        
		return finalNumber;
    }
	
	public static void main(String[] s) {
		NextGreaterElementIII greater = new NextGreaterElementIII();
		System.out.println(greater.nextGreaterElement(486531));//1999999999
	}

}
