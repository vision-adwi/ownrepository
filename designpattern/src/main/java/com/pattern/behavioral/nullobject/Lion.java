package com.pattern.behavioral.nullobject;

public class Lion extends Animal {

	@Override
	public void aboutMe() {
		System.out.println("I am the King of the jungle and a carnivores animal.");

	}

	@Override
	public String sound() {
		return "roaaaaaarrrrr.....";
	}

}
