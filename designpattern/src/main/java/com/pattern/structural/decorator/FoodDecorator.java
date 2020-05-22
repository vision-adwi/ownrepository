package com.pattern.structural.decorator;

public abstract class FoodDecorator implements Food {
	private Food food;
	
	public FoodDecorator(Food theFood) {
		food = theFood;
	}

	@Override
	public String prepare() {
		return food.prepare();
	}

	@Override
	public double price() {
		return food.price();
	}

}
