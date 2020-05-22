package com.pattern.behavioral.templatemethod;

import com.pattern.behavioral.templatemethod.concrete.ConcreteHouse;
import com.pattern.behavioral.templatemethod.concrete.GlassHouse;

/*
Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.
Base class declares algorithm 'placeholders', and derived classes implement the placeholders.

The component designer decides which steps of an algorithm are invariant (or standard), and which are variant (or customizable).
The invariant steps are implemented in an abstract base class, while the variant steps are either given a default implementation, or no implementation at all.
*/
public class TemplateMethodDemo {

	public static void main(String[] args) {
		HouseTemplate houseTemplate = new GlassHouse();
		houseTemplate.buildHouse();

	}

}
