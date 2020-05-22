package com.pattern.behavioral.visitor.concrete;

import com.pattern.behavioral.visitor.Item;

public class Book implements Item {
	String isbn;
	String name;
	float price;
	
	public Book(String theIsbn, String theName, float thePrice) {
		isbn = theIsbn;
		name = theName;
		price = thePrice;
	}
	
	public float getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "ISBN - " + isbn + " Name - " + name + " at price " + price;
	}

	/*@Override
	public float accept(Visitor visitor) {
		return visitor.visit(this);

	}*/

}
