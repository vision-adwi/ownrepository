package com.algorithm.sorting;

public class QuickSort extends AbstractSort {
	public QuickSort(int[] unsorted) {
		super(unsorted);
	}

	@Override
	protected void perform() {
		quickSort(0, elements.length - 1);
	}

	private void quickSort(int left, int right) {
		if ( left < right) {
			int i = left - 1;

			int pivot = elements[right];
			int tmp;
			for (int j = left; j <= right; j++) {
				if (elements[j] <= pivot) {
					tmp = elements[++i];
					elements[i] = elements[j];
					elements[j] = tmp;
				}
			}

			quickSort(left, (i - 1));
			quickSort((i + 1), right);

		}
	}

	@Override
	protected String getSortName() {
		return "Quick Sort";
	}
}
