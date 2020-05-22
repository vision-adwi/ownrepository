package com.pattern.behavioral.nullobject;

public class NoAnimal extends Animal {

	@Override
	public void aboutMe() {
		System.out.println("NULL object");

	}

	@Override
	public String sound() {
		return "No sound";
	}

}
