package com.pattern.structural.decorator;

public class BreadBaseFood implements Food {
	private String foodDescription = "Bread and salsa";
	private double addOnPrice = 12.0;

	@Override
	public String prepare() {
		return foodDescription;
	}

	@Override
	public double price() {
		return addOnPrice;
	}

}
