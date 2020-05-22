package com.algorithm.sorting;
/*
When to Use
1. When input is already sorted.
2. Space is a concern.
3. Easy to implement. 

When not to use
1. Average case time complexity is poor.
*/

public class BubbleSort extends AbstractSort{
	BubbleSort(int[] unsorted) {
		super(unsorted);
	}
	
	@Override
	protected void perform() {
		int tmp;
		for (int i = elements.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if(elements[j] > elements[j+1]) {
					tmp = elements[j];
					elements[j] = elements[j+1];
					elements[j+1] = tmp;
				}
			}
		}
	}

	@Override
	protected String getSortName() {
		return "Bubble Sort";
	}

}
