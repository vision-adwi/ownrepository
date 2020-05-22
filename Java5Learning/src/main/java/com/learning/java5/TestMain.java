package com.learning.java5;

import com.learning.java5.annotation.DeprecatedDemo;
/*
Java 5.0 Features
- Enhanced for loop
- Autoboxing/autounboxing
- Static import
- Varargs
- Generics
- Metadata(annotation)
- Typesafe Enums
- Concurrency
- Instrumentation
*/
public class TestMain {

	public static void main(String[] args) {
		DeprecatedDemo dd = new DeprecatedDemo(); 
		dd.myMsg();
		dd.myMsg2("Hello ", "world");
	}

}
