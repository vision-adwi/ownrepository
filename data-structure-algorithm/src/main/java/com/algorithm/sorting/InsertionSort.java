package com.algorithm.sorting;

public class InsertionSort extends AbstractSort{
	public InsertionSort(int[] unsorted) {
		super(unsorted);
	}

	@Override
	protected void perform() {
		int tmp;
		for (int i = 1; i < elements.length; i++) {
			int j = i;
			while ((j > 0) && (elements[j] < elements[j - 1]) ) {
				tmp = elements[j];
				elements[j] = elements[j - 1];
				elements[j - 1] = tmp;

				j--;
			}
		}
	}

	@Override
	protected String getSortName() {
		return "Insertion Sort";
	}
}
