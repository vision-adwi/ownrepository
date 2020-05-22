package com.pattern.structural.flyweight;
/*
Flyweight design pattern is used when we need to create a lot of Objects of a class. 
Since every object consumes memory space that can be crucial for low memory devices, 
such as mobile devices or embedded systems, flyweight design pattern can be applied 
to reduce the load on memory by sharing objects.

A Flyweight Pattern says that just "to reuse already existing similar kind of objects 
by storing them and create new object when no matching object is found".

To apply flyweight pattern, we need to divide Object property into intrinsic 
and extrinsic properties. Intrinsic properties make the Object unique whereas 
extrinsic properties are set by client code and used to perform different operations.
*
*/
public class FlyweightDemo {
	private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };

	public static void main(String[] args) {
		for(int i=0; i < 20; ++i) {
	         Circle circle = (Circle)FlyweightFactory.getCircle(getRandomColor());
	         circle.setX(getRandomX());
	         circle.setY(getRandomY());
	         circle.setRadius(100);
	         circle.draw();
	      }

	}

	private static String getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}

	private static int getRandomX() {
		return (int) (Math.random() * 100);
	}

	private static int getRandomY() {
		return (int) (Math.random() * 100);
	}

}
