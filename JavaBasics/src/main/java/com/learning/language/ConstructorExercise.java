package com.learning.language;

public class ConstructorExercise {

	public static void main(String[] args) {
		Parent parent = new Parent(4);
		System.out.println(parent.Parent(5));
		Parent obj = new Derived();

	}

}
/*
Declaration rules: 1. If there is no constructors defined then a no-argument constructor shall  be injected by compiler.
					  If there is any constructor defined by user then no injection by compiler.
				   2. Any access specifiers like public, protected, default or private can be provided to constructors. A constructor
				      can not be abstract, final or synchronized.
				   3. Constructor to be qualified to be called as constructor if they have the same name as Class they belong to 
				      and there is no return type.
				   4. Continuation to the point 3, if there is a return type associated then that (constructor) will be converted
				      to an ordinary method. A constructor name with no return type(a valid constructor, infact) can be shared with a 
				      method (with same name and parameters)[though compiler shows a warning].
Assignment rules: 
Access rules: 1. Constructors can be invoked by a new operator. 
			  2. Constructors can be invoked by super or this keyword also. But constructor call must be the first statement in
			     a constructor. This is called 'constructors chaining'.
			  3. Static initializer and instance initializer block are executed before the constructor.
Inheritance rules: 1. Constructors are not inherited by sub-classes.
				   2. If constructor of super class is not called(as a first statement in derived class constructors) explicitly 
			          by user then compiler will inject a call to no-argument constructor of super class.
 				   3. If no-argument constructor is missing in super class(no injection by compiler due to presence of user defined
 				      argument based constructor(s)) then compiler will complain in case there is no user supplied construct(s) present
 				      in sub-class. *If user supplies any argument based constructors then they should provide a no-argument constructor as well.
Inner class rules: 1. Anonymous class can not have explicit constructor.
Interface rules: 1. Interfaces, obviously, doesn't have any constructors.
Serialization rules: 1. There must be a default constructor exist for a class which implements the Externalizable interface otherwise
						de-serialization will fail.
 */
class Parent {
	String Parent(int i) {
		System.out.println("It's a no-argument constructor of parent class");
		return "done";
	}
	Parent(int i) {
		
	}
	Parent() {
		
	}
	
}

class Derived extends Parent{
	Derived() {
		super(5);
	}
	Derived(int i) {
		//int j = 5;
		this();
	}
	
}
