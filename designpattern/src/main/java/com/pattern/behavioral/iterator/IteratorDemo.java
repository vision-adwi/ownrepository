package com.pattern.behavioral.iterator;

import com.pattern.behavioral.iterator.concrete.NameContainer;

/*The iterator pattern provides a way to access the elements of an aggregate object without exposing its underlying representation.*/

public class IteratorDemo {

	public static void main(String[] args) {
		Iterable container = new NameContainer();
		
		Iterator iterator = container.iterator();
		while(iterator.hasMore())
			System.out.println(iterator.next());
	}

}
