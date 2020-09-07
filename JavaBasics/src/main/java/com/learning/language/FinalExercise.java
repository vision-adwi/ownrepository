package com.learning.language;

public class FinalExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
Declaration rules: This modifier can be applied to class, method, variable, local variables and parameters level.
Assignment rules: 1. Final instance variable must either be initialized at declaration time or (blank final variable) should be 
					 initialized in all of it's constructors(any where in the constructor) or in free-floating non-static block.
				  2. If instance variable is once initialized then it can not be re-initialized or updated.
				  3. Local variable has no compulsion of being initialized but once initialized can not be changed.
				  4. Earlier(pre java8), only final local classes can be accessed in anonymous inner class or local inner class.
				  5. When the static keyword is used with final modifier then the variable becomes a compile time constant.
Access rules: 
Inheritance rules: 1. Final class can not be extended(prevented from the 'power of inheritance'). Once you declare a class final
					  all it's methods declared final.
				   2. Final methods can not be overridden by sub-classes.
Inner class rules: 
Interface rules: 1. Member variable define here is final(implicitly), not assigning value during declaration will throw error.
Serialization rules:
*/

interface InterfaceA {
	int x = 0; //permitted modifiers: public, static, final
	int getX(); //permitted modifiers: public, static, abstract, default, strictfp,
}

final class FinalA {
	final int finalVar;
	{
		finalVar = 5;
	}
	FinalA(int val) {
		super();
		System.out.println("");
		//finalVar = val;
	}
	
	FinalA() {
		super();
		System.out.println("");
		//finalVar = 4;
	}
	public int calcResult(int val) {
		final int res;
		System.out.println("");
		//res = val;
		return 5;
	}
	
}


