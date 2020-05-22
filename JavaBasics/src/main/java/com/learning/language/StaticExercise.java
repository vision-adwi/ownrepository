package com.learning.language;

public class StaticExercise {

	public static void main(String[] args) {
		StaticA objA = new StaticA();
		objA.establishment = "ABC Corp";		//Warning: Should be accessed in static way.
		objA.num = 5;
		System.out.println(StaticA.getEstablishment() + ":" + objA.getNum()); 			
			
		StaticB objB = new StaticB();
		objB.establishment = "Reliance Industries";
		objB.num = 10;
		//Here getNum() method will return num member from base class which is 0 in this case.
		System.out.println(objB.getEstablishment() + ":" + objB.getNum());
		objB.show();
		//System.out.println(StaticA.getEstablishment() + ":" + objA.getNum()); 
		
		objA = objB;
		objA.getEstablishment();
	}

}

/*
Declaration rules: 1. Static local variables are not allowed.
				   2. Static can be applied at class level(except top level), method level, variable and block level.
				   3. static variable with same name can be declared in sub-class(both the class maintain their respective variable)
				   4. static method with same name can be declared in sub-class(but they don't participate in polymorphism and this is 
				   not called method overriding)
Assignment rules:
Access rules: 1. Static variables/methods are accessed from the reference class(not from implementation object).
              2. All the visible static members from the base class are available through derived class(or object). If the static member 
              with the same name is present in the derived class then that method will be accessed.(Mind it, this is not overriding !!).
              This called hiding.
Inheritance rules:
Inner class rules: Static nested class can only access static members of outer class.
Interface rules:
Serialization rules:
 */
class StaticA {
	public static String establishment;	//static can be defined at variable level
	public int num;
	

	public static String getEstablishment() {	//static can be defined at method level
		System.out.println("getEstablishment() from base class");
		return establishment;
	}
	
	public int getNum() {
		return num;
	}
	
	private static class InnerNested {	//static can be defined at class level(except top level class)
		public void reset() {
			//num = 0;	//Can not make a static reference to a non-static field num	
			establishment = "";
		}
	}
}

class StaticB extends StaticA {
	public static String establishment;
	public int num;

	public static String getEstablishment() {	
		System.out.println("getEstablishment() from base class");
		return establishment;
	}
	
	public static void show() {
		System.out.println(StaticB.establishment + " : " + StaticA.establishment);
	}
}