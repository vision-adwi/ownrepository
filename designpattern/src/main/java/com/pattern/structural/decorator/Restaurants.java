package com.pattern.structural.decorator;

/*
Decorator design pattern is used to modify the functionality of an object at runtime. 
At the same time other instances of the same class will not be affected by this, 
so individual object gets the modified behavior. 
This pattern is know as WRAPPER as well.

A Decorator Pattern says that just "attach a flexible additional responsibilities to an object dynamically".
In other words, The Decorator Pattern uses composition instead of inheritance to extend the functionality 
of an object at runtime.
*/
public class Restaurants {

	public static void main(String[] args) {
		//1.
		Food theFood = new Beverages(new ChineseFood(new RiceBaseFood()));
		
		//2.
		//Food theFood = new Beverages(new NonVegFood(new BaseFood()));
		
		//3.
		//Food theFood = new ChineseFood(new NonVegFood(new BaseFood()));
		
		//4.
		//Food theFood = new BaseFood();

		System.out.println(theFood.prepare());
		System.out.println("Bill: " + theFood.price());

	}
}
