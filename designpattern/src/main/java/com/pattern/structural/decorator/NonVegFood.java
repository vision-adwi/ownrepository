package com.pattern.structural.decorator;

public class NonVegFood extends FoodDecorator {
	private String foodDescription = " with grilled chicken";
	private double addOnPrice = 45.0;

	NonVegFood(Food theFood) {
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
