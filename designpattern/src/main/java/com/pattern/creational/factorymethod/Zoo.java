package com.pattern.creational.factorymethod;

public class Zoo {

	public static void main(String[] args) {
		Animal animal = AnimalFactory.getAnimal(AnimalFactory.Sound.ROAR);
		System.out.println(animal.characterstics());

	}

}
