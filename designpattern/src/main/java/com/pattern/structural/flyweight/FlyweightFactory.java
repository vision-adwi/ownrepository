package com.pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
	//This data structure persists the objects of <property, object>
	static final Map<String, Shape> shapes = new HashMap<>();
	
	public static Shape getCircle(String color) {
		Shape circle;
		
		if((circle = shapes.get(color) ) == null) {
			circle = new Circle(color);
			
			shapes.put(color, circle);
			System.out.println("New Circle object with property " + color + " is created.");
		}
		
		return circle;
	}

}
