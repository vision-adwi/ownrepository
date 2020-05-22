package com.pattern.behavioral.nullobject;

public class AnimalFactory {
	public static Animal getAnimal(String animal) {
		Animal type = null;
		
		switch(animal) {
		case "cow":
			type = new Cow();
			break;
		case "lion":
			type = new Lion();
			break;
		case "dog":
			type = new Dog();
			break;
		default:
			type = new NoAnimal();
		
		}
		
		return type;
	}

}
