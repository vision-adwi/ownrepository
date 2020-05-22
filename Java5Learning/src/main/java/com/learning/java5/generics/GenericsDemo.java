package com.learning.java5.generics;

import com.learning.java5.generics.custom.Child;
import com.learning.java5.generics.custom.DerivedGenerics;
import com.learning.java5.generics.custom.Parent;
import com.learning.java5.generics.custom.CustomGenerics;

public class GenericsDemo {

	public static void main(String[] args) {
		CustomGenerics<String> theStringInstance = new CustomGenerics<>();//Type inference
		theStringInstance.setItem("Sample");
		System.out.println(theStringInstance.getItem());
		
		CustomGenerics<Long> theLongInstance = new CustomGenerics<Long>(56L);
		System.out.println(theLongInstance.getItem());
		
		Child theDemoClass = new Child(10, 20);
		CustomGenerics<Child> theDemoInstance = new CustomGenerics<Child>(theDemoClass);
		System.out.println(theDemoInstance.getItem());

		CustomGenerics<Parent> parentInstance = new CustomGenerics<>();
		CustomGenerics<Child> childInstance = new CustomGenerics<>();
		
		WrapperClass wrapper = new WrapperClass();
		wrapper.setObject(theStringInstance);
		wrapper.setParentObject(parentInstance);
		CustomGenerics<? extends Parent> returnedValue = wrapper.setParentTypeObject(childInstance);
		wrapper.setChildSuperObject(parentInstance);
		
		String message = wrapper.setAnyObject("Good", 11);
		
		CustomGenerics derived = new DerivedGenerics();
		derived.setItem("Hi");
		derived.getItem();
		
		CustomGenerics derived1 = new DerivedGenerics();
		//derived1.s
	}

}
