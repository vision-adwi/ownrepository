package com.learning.language;

public class OverloadingExercise {

	public static void main(String[] args) {
		Exercise exercise = new Exercise();
		
		exercise.execute(new Father());
		exercise.execute(new Child());
		
		exercise.showValues(3);
		exercise.showValues(8, 9);
		//exercise.showValues(null); //
		exercise.showValues();
		exercise.showValues(new int[]{5, 8});
		
		exercise.displayDigit(4L);

	}

}

/*
Variable length argument - Rules
1. Variable length argument should be the last argument in the list.
2. Caller can pass no-arg, any number of arg of same time OR array but it can not pass null.(in case of var length argument)
3. JVM first try to find out the method with exact number/type of parameter, if that is not available then
it will match var-length argument method.
4. Compiler will error out if the same method with array parameter of same time is present.
5. If there is a method with array parameter, caller can either pass an array or null.
 */

class Exercise {
	public void execute(Father father) {
		System.out.println("Parent class parameter");
	}
	
	public void execute(Child child) {
		System.out.println("Child class parameter");
	}
	
	public void showValues(int... allx) {
		System.out.println("Variable length parameters.");
		for(int x : allx) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	
	public void showValues(int x, int y) {
		System.out.println("Exact parameters.");

	}
	// This would be considered at duplicate method
	/*
	public void showValues(int[] xArray) {
		System.out.println("Parameter with array type");
	} 
	*/
	
	public void displayDigit(int i) {
		System.out.println("Integer display : " + i);
	}
	
	public void displayDigit(Integer i) {
		System.out.println("Wrapper integer display : " + i);
	}
	
	public void displayDigit(long l) {
		System.out.println("Long display : " + l);
	}
}

class Father {
	
}

class Child extends Father {
	
}
