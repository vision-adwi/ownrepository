package com.learning.language;

public class AbstractExercise {

	public static void main(String[] args) {
		AbstractC1 c1 = new AbstractC2();
		AbstractC1.print();
		System.out.println(AbstractC1.val);
		//c1 = new AbstractC1();

	}

}

/*
Declaration rules: 1. Only class and methods can be declared abstract.
				   2. Class can be declared abstract without satisfying any rules but it must be declared abstract if
				      there is any member method declared abstract.
				   3. Method can not be declared abstract if it has valid body. This condition is mutually exclusive.
				      Method must have to be declared abstract if there is no body.
Assignment rules: 1. Abstract class can be used as a reference but object can not be created of abstract class('prevented
                     from being created').
Access rules: 1. All the static members can be accessed through abstract class.
Inheritance rules: 1. This is best fit for polymorphism.
 				   2. All the abstract method must be defined by the subclass(es) otherwise subclass must also be declared abstract.
Inner class rules: 1. Inner classes can also be declared abstract.
Interface rules:
Serialization rules:
 */

abstract class AbstractC1 {
	static int val;
	static {
		val = 5;
	}
	static void print() {
		System.out.println("This is abstract class");
	}
	AbstractC1() {
		
	}
	abstract int caculate(int x, int y);
}

class AbstractC2 extends AbstractC1 {
	int caculate(int x, int y) {
		return x = y;
	}
	
	//abstract int method(int z);
}
