package com.learning.language;

public class InheritanceExercise {

	public static void main(String[] args) {
		//BaseA base = new DerivedA();
		//base.display();
		
		DerivedA derived = new DerivedA();
		derived.display();

	}

}
/*
Declaration rules: 1. Any private method in a super class can be re defined in sub-classes. And sub-class can choose to have
                      any access specifier.(Since private member has no visibility outside the class and that is not participating
                      in method overriding so no issue.)
				   2. In case of overriding, the access-specifier can not be reduced in sub-class.(obviously other than private)
				   3. Declaring same member data in derived-class is allowed. 
Assignment rules: 
Access rules: 1. In case of polymorphism, method binding happen at run time and that is called dynamic method dispatch. But data binding
                 happen at compile time.
Inheritance rules: 1. All the protected/public members of super class can be accessed by sub-classes through super keyword.
Inner class rules: 
Interface rules:
Serialization rules:
 */
class BaseA {
	int i = 5;
	public void display() {
		System.out.println("display() from base class : " + i);
		inner();
	}
	void inner() {
		System.out.println("Inner from base : ");
	}
	private void showOff() {
		System.out.println("showOff() from base class : " + i);
	}
}

class DerivedA extends BaseA{
	int i = 10;
	/*void display() {
		System.out.println("This is derived class method"+i);
	}*/
	void inner() {
		System.out.println("Inner from derived " + i + " : " + super.i);
	}
	public void showOff() {
		System.out.println("showOff() from derived class : " + i);
	}
}
