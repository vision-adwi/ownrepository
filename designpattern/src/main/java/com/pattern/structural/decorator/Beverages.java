package com.pattern.structural.decorator;

public class Beverages extends FoodDecorator {
	private String foodDescription = " and beverages";
	private double addOnPrice = 8.5;

	Beverages(Food theFood) {
		super(theFood);
	}
	
	@Override
	public String prepare() {
		return super.prepare() + foodDescription;
	}

	@Override
	public double price() {
		return super.price() + addOnPrice;
	}

}