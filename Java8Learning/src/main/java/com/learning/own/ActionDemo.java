package com.learning.own;

public class ActionDemo {
	public static void main(String[] s) {
		Navigator theNavigator = new Navigator();

		theNavigator.addItem(10);
		theNavigator.addItem(20);
		theNavigator.addItem(30);
		theNavigator.addItem(40);

		theNavigator.filterAll(element -> element > 10).iterateAll(
				item -> System.out.println(item));
	}

}
