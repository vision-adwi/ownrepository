package com.learning.java8.functionalinterface;

interface Echo {
	//default method is new to JAVA 8. Java provides a facility to create default methods inside the interface. Can be overridden.
	default void sound() {
		System.out.println("Wooooooo...");
	}
}

interface Drawable {
	void draw();
	void setQuardinates();
	
	String toString();
	default int calculate() {
		return 0;
	}
}

@FunctionalInterface
interface Sayable extends Echo{ //Possible to extend any interface that doesn't have any abstract method.
	void sayIt();
	//void doIt(); //Not possible to have more than one abstract method declaration
	String toString(); //Possible to have any method declared of Object class
	default int calculate() { //Possible to declare any numbers of default methods
		return 0;
	}
	
}

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		Sayable saySomething = () -> {
			System.out.println("Hello");
		};
		//Above code is snippet is similar to this
		/*	
		Sayable saySomething = new Sayable() {
			public void sayIt() {
				System.out.println("Hello");
			}
		};
	 	*/
		saySomething.sayIt();
		saySomething.sound();
	}

}

/*
 * 1. An Interface that contains exactly one abstract method is known as functional interface.
 * 2. It can have any number of default, static methods but can contain only one abstract method.
 * 3. It can also declare methods of object class.
 * 4. A functional interface can extends another interface only when it does not have any abstract method.
 * 
 * 
 * Note - Functional Interface is also known as Single Abstract Method Interfaces or SAM Interfaces.
 * */
