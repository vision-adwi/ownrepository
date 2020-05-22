package com.pattern.behavioral.visitor.concrete;

import com.pattern.behavioral.visitor.Item;

public class Fruit implements Item {
	String name;
	float pricePerKg;
	float weight;

	public Fruit(String theName, float thePricePerKg, float theWeight) {
		weight = theWeight;
		name = theName;
		pricePerKg = thePricePerKg;
	}
	
	public float getPrice() {
		return pricePerKg * weight;
	}
	
	public float getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Fruit - " + name + " with weight - " + weight + " at price " + pricePerKg;
	}
	
	/*@Override
	public float accept(Visitor visitor) {
		return visitor.visit(this);

	}*/

}
