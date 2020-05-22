package com.pattern.behavioral.nullobject;
/*
In Null Object pattern, a null object replaces check of NULL object instance. 
Instead of putting if check for a null value, Null Object reflects a do nothing relationship. 
Such Null object can also be used to provide default behaviour in case data is not available.
*/
public class NullObjectDemo {

	public static void main(String[] args) {
		Animal animal = AnimalFactory.getAnimal("camel");
		animal.aboutMe();
		System.out.println(animal.sound());

	}

}
