package com.learning.libraries;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UtilDemo {
	
	public static void main(String[] args) {
		//math();
		arrays();
	}

	public static void arrays() {
		int[] a = {1,2,3,9,4,7,5};
		System.out.println("Arrays.toString(int[] a)");
		System.out.println(Arrays.toString(a));
		
		System.out.println("\nArrays.sort(int[] a)");
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		System.out.println("\nArrays.binarySearch(int[] a, int key)");
		System.out.println(Arrays.binarySearch(a, 9));

		System.out.println("\nArrays.copyOf(int[] original, int newLength)");
		int aCopy[] = Arrays.copyOf(a, 4);
		System.out.println(Arrays.toString(aCopy));
		
		System.out.println("\nArrays.copyOfRange(int[] original, int from, int to)");
		int aRange[] = Arrays.copyOfRange(a, 3, 7);
		System.out.println(Arrays.toString(aRange));
		
		System.out.println("\nArrays.fill(int[] a, int value)");
		int[] vector = new int[4];
		Arrays.fill(vector, 9);
		System.out.println(Arrays.toString(vector));
		
		System.out.println("\nArrays.hashCode(int[] a)");
		System.out.println(Arrays.hashCode(vector));
		
		System.out.println("\nArrays.equals(int[] a, int[] a2)");
		System.out.println(Arrays.equals(aCopy, aRange));
		
		List list = Arrays.asList(a);
		
		//Arrays.deepEquals(a1, a2)
		//Arrays.deepHashCode(a);
		//Arrays.deepToString(a);
		//Arrays.parallelPrefix(array, op);
		//Arrays.parallelSetAll(array, generator);
		//Arrays.parallelSort(a);
		//Arrays.stream(array);
		//Arrays.spliterator(array);
		//Arrays.setAll(array, generator);
	}
	
	private static void collectionsUtil() {
		//Collections
	}
	
	private static void wrapper() {
		String numberString = "15";
		
		int number = Integer.parseInt(numberString);
		numberString = String.valueOf(number);
		
		Integer numberObject = Integer.valueOf(number);
		numberObject = Integer.valueOf(numberString);
		
		numberObject.intValue();
		numberObject.toString();
	}
	
	private static void math() {
		System.out.println("Math.abs(-9)    : " + Math.abs(-9));
		System.out.println("Math.abs(70)    : " + Math.abs(70));
		System.out.println("Math.ceil(3)    : " + Math.ceil(3));
		System.out.println("Math.ceil(3.1)  : " + Math.ceil(3.1));
		System.out.println("Math.ceil(-7.6) : " + Math.ceil(-7.6));
		System.out.println("Math.floor(3)   : " + Math.floor(3));
		System.out.println("Math.floor(3.1) : " + Math.floor(3.1));
		System.out.println("Math.floor(-7.6): " + Math.floor(-7.6));
		System.out.println("Math.round(3)   : " + Math.round(3));
		System.out.println("Math.round(3.1) : " + Math.round(3.1));
		System.out.println("Math.round(5.51): " + Math.round(5.51));
		System.out.println("Math.exp(1)     : " + Math.exp(1));
		System.out.println("Math.exp(2)     : " + Math.exp(2));
		System.out.println("Math.pow(2, 3)  : " + Math.pow(2, 3));
		System.out.println("Math.random()   : " + Math.random());
		System.out.println("Math.min(17, 69): " + Math.min(17, 69));
		System.out.println("Math.max(17, 69): " + Math.max(17, 69));
	}

}
