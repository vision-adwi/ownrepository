package com.pattern.structural.decorator;

public class ChineseFood extends FoodDecorator {
	private String foodDescription = " with manchurian";
	private double addOnPrice = 35.0;

	ChineseFood(Food theFood) {
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
