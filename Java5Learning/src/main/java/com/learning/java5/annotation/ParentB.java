package com.learning.java5.annotation;
/*
Using @Override annotation while overriding a method is considered as a best practice for coding in java because of the following two advantages:
1. If programmer makes any mistake such as wrong method name, wrong parameter types while overriding, you would get a compile time error.
2. It improves the readability of the code. So if you change the signature of overridden method then all the sub classes that overrides 
the particular method would throw a compilation error.
*/
class ParentB extends ParentA {
	
	@Override
	void calcA()
	{
	}

}
