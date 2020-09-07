package com.practice.tricky;

import java.math.BigDecimal;

public class Tricky11 {

	public static void main(String[] args) {
		equalMethod();
		
		double diff = 1.1 - 1.0;
		System.out.println("1.1 - 1.0 = " + diff);
		
		float diff1 = 1.1f - 1.0f;
		System.out.println("1.1f - 1.0f = " + diff1);
		
		//Solution - Use BigDecimal
		BigDecimal minuend = new BigDecimal("1.1");
		BigDecimal difference = minuend.subtract(new BigDecimal("1.0"));
		System.out.println(difference);
		

	}
	
	private static void equalMethod() {
		Long l = new Long(0);
		System.out.println("l.equals(0)  - " + l.equals(0));
		System.out.println("l.equals(0L) - " + l.equals(0L));
		
		Double d = new Double(0);
		System.out.println("d.equals(0)  - " + d.equals(0));
		System.out.println("d.equals(0d) - " + d.equals(0d));

	}

}
