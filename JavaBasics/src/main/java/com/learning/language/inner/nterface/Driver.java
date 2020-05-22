package com.learning.language.inner.nterface;

public class Driver {

	public static void main(String[] args) {
		NestingInterface part = new ImplementingClass();
		part.show();
		
		NestingInterface.Nesting innerPart = new ImplementingClassNested();
		innerPart.display();
		
		OuterClass.Inner inner = new ImplementingClassInterface();
		inner.now();

	}

}
