package com.pattern.behavioral.nullobject;

public class Cow extends Animal {

	@Override
	public void aboutMe() {
		System.out.println("I am the most useful pet who gives milk and a hebivores animal.");

	}

	@Override
	public String sound() {
		return "moo moo moo";
	}

}
