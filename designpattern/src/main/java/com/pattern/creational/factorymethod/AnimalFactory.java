package com.pattern.creational.factorymethod;

public class AnimalFactory {
	static enum Sound {
		MEOW, ROAR, WUF, MOO
	}
	
	public static Animal getAnimal(Sound sound) {
		switch (sound) {
		case MEOW:
			return new Cat();
		case ROAR:
			return new Lion();
		case WUF:
			return new Dog();
		case MOO:
			return new Cow();
		default:
			return null;
		}
	}
}
