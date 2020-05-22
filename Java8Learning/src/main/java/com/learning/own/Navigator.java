package com.learning.own;

public class Navigator {
	Integer[] elements;
	int filled = 0;

	public Navigator() {
		this(10);
	}

	public Navigator(int size) {
		elements = new Integer[10];

	}

	public void addItem(Integer element) {
		elements[filled++] = element;
	}

	public void iterateAll(ActionInterface action) {
		for (Integer element : elements) {
			if (null != element) {
				action.doIt(element);
			}

		}
	}

	public Navigator filterAll(FilterInterface filter) {
		Navigator theNavigator = new Navigator();
		for (Integer element : elements) {
			if (element != null && filter.filterIt(element)) {
				theNavigator.addItem(element);
			}
		}
		return theNavigator;
	}

}
