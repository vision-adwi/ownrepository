package com.learning.language.inner;
import static com.learning.language.inner.OuterNesting.STATIC_MEMBER;;
public class Demo {

	public static void main(String[] args) {
		OuterNesting.Nested nested = new OuterNesting.Nested(); //No need to have object of outer class(for static nested class).
		nested.display();
		System.out.println(STATIC_MEMBER);
		
		System.out.println(OuterNesting.Nested.getStaticMemberOfOuterClass());
		
		OuterInner outer = new OuterInner();
		System.out.println(outer.getValue());
		
		OuterInner.Inner inner = outer.new Inner();
		inner.setOuterMember(20);
		inner.setInnerMember(100);
		
		System.out.println("Outer: " + inner.getOuterMember() + " Inner: " + inner.getInnerMember());
		
		LocalInner local = new LocalInner();
		System.out.println(local.getData());

	}
	
	

}

/*
Declaration - 1. Inner class(non-static) and local inner class can not define the static members.
              2. ..but they can define static final.
              3. Inner class(non-static) can define the same name variable with the outer class(obviously non-static)

Access rules - 1. Static inner(nested) class can only access static members of outer class.
               2. Non-static member variables of outer class(in non-static inner) can be accessed like Outer.this.xxx.

Object creation - 1. Outer class object is needed to instantiate inner class object.
 */
