package com.pattern.structural.decorator;

public class RiceBaseFood implements Food {
	private String foodDescription = "Rice and plain gravy";
	private double addOnPrice = 15.0;

	@Override
	public String prepare() {
		return foodDescription;
	}

	@Override
	public double price() {
		return addOnPrice;
	}

}
