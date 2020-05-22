package com.pattern.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

import com.pattern.behavioral.visitor.concrete.Book;
import com.pattern.behavioral.visitor.concrete.CartVisitor;
import com.pattern.behavioral.visitor.concrete.Fruit;

/*
 * Visitor is a behavioral design pattern that lets you separate algorithms from the objects on which they operate.
 */
public class VisitorDemo {

	public static void main(String[] args) {
		Visitor visitor = new CartVisitor();
		List<Item> items = new ArrayList<>();

		items.add(new Book("4879-I", "Harry Potter", 56f));
		items.add(new Book("5783-F", "Fanny Hill", 47f));
		items.add(new Fruit("Guava", 2.4f, .8f));
		items.add(new Fruit("Grapes", 1.6f, 5.8f));

		float bill = 0.0f;
		for (Item item : items) {
			bill = bill + item.accept(visitor);
		}

		System.out.println("Total cart value is " + bill);

	}

}
