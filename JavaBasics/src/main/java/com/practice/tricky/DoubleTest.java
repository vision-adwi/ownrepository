package com.practice.tricky;

public class DoubleTest {

	public static void main(String[] args) {
		System.out.println("Double min value - " + Double.MIN_VALUE);
		System.out.println("Double max value - " + Double.MAX_VALUE);
		System.out.println("Not-a-number     - " + Double.isNaN('a'));
		System.out.println("Is infinite      - " + Double.isInfinite(55556666666666666666666655555555555444444444444444444.5));
		System.out.println("Minimum(0.0, min)- " + Math.min(0.0d, Double.MIN_VALUE));
		System.out.println("1.0/0.0          - " + (1.0 / 0.0));
		Double x = Double.NaN;
		System.out.println("x == Double.NaN  - " + (x == Double.NaN));
		System.out.println("Double.isNaN(x)  - " + (Double.isNaN(x)));

	}

}
