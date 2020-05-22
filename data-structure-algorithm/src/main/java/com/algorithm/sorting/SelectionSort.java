package com.algorithm.sorting;
/*
When to Use
1. Space is a concern.
2. Easy to implement. 

When not to use
1. When time complexity is a concern.
*/
public class SelectionSort extends AbstractSort{
	public SelectionSort(int[] unsorted) {
		super(unsorted);
	}
	
	@Override
	protected void perform() {
		int tmp;
		for (int i = 0; i < elements.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < elements.length; j++) {
				if (elements[j] < elements[minIndex] ) {
					minIndex = j;
				}
			}
			if(minIndex != i) {
				tmp = elements[i];
				elements[i] = elements[minIndex];
				elements[minIndex] = tmp;
			}
		}
	}

	@Override
	protected String getSortName() {
		return "Selection Sort";
	}

}
