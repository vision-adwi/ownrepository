package com.pattern.behavioral.visitor.concrete;

import com.pattern.behavioral.visitor.Item;
import com.pattern.behavioral.visitor.Visitor;

public class CartVisitor implements Visitor {

	@Override
	public float visit(Item item) {
		float value = 0;
		Visitor.super.visit(item);
		if (item instanceof Book) {
			value = visitBook((Book) item);
		} else if (item instanceof Fruit) {
			value = visitFruit((Fruit) item);
		}

		return value;
	}

	private float visitBook(Book book) {
		float value = 0;
		// Rs. 5 discount if book cost is more than 50
		if (book.getPrice() > 50) {
			value = book.getPrice() - 5;
		} else {
			value = book.getPrice();
		}
		return value;
	}

	private float visitFruit(Fruit fruit) {
		float value = 0;
		// 10% discount if fruit weigh is more than 5 kg
		if (fruit.getWeight() > 5) {
			value = fruit.getPrice() * 0.9f;
		} else {
			value = fruit.getPrice();
		}
		return value;
	}

}
