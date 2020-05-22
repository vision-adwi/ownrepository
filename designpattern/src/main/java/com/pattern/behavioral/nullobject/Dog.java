package com.pattern.behavioral.nullobject;

public class Dog extends Animal {

	@Override
	public void aboutMe() {
		System.out.println("I am an omnivores animal and being loved by people a lot.");

	}

	@Override
	public String sound() {
		return "wuf wuf wuf";
	}

}
