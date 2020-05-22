package com.pattern.behavioral.mediator;

public class Runway {
	String name;

	public Runway(String theName, ATController controller) {
		name = theName;
		controller.registerRunway(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Runway [name=" + name + "]";
	}

}
