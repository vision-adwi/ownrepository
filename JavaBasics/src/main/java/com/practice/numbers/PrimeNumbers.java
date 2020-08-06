package com.practice.numbers;

public class PrimeNumbers {

	public static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}

		for (int i = 2; (n / i) >= i; i++) {
			if ((n % i) == 0) {
				return false;
			}
		}

		return true;
	}

	public static void printPrimeNumber(int lastRange) {
		for (int i = 2; i <= lastRange; i++) {
			if (isPrime(i)) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static int totalPrimeNumberInRange(int end) {
		int count = 0;
		for(int i = 2; i <= end; i++) {
			if(isPrime(i)) {
				count++;
			}
		}
		
		return count;
	}
	
	public static void numberFacts(int n) {
		//System.out.println("[" + 1 + "," + n + "]");
		for (int i = 2; (n / i) >= i; i++) {
			if ((n % i) == 0) {
				System.out.println("[" + i + "," + (n/i) + "]");
			}
		}
	}
	
	public static boolean perfectSquare(int n) {
		boolean isSquare = false;
		for (int i = 2; (n / i) >= i; i++) {
			if ( ((n % i) == 0) && 
					((i * i) == n) ){
				isSquare = true;
			}
		}
		return isSquare;
	}
	
	//The Sieve of Eratosthenes
	public static int primeNumbersCount(int n) {
		boolean[] isPrime = new boolean[n];
		for(int i = 2; i < n; i++) {
			isPrime[i] = true;
		}
		
		for (int i = 2; i * i < n; i++) {
			if (isPrime(i)) {
				for (int j = i * i; j < n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		
		int count = 0;
		for(int i = 2; i < n; i++)
			if(isPrime(i))
				count++;
		
		return count;
	}

	public static void main(String[] args) {
		//printPrimeNumber(100);
		long start = System.nanoTime();
		System.out.println("Total prime numbers upto 1500000 : " + totalPrimeNumberInRange(15000000));
		long end = System.nanoTime();
		System.out.println("Time taken to find total prime numbers - " + (end - start) / 1000000 + " milliseconds.");
/*		
		start = System.nanoTime();
		System.out.println("Total prime numbers upto 1500000 : " + primeNumbersCount(15000000));
		end = System.nanoTime();
		System.out.println("Time taken to find total prime numbers - " + (end - start) / 1000000 + " milliseconds.");

		numberFacts(15);
		System.out.println("Perfect Square (999) - " + perfectSquare(999));
		System.out.println("Perfect Square (1089) - " + perfectSquare(1089));
		*/
	}

}
