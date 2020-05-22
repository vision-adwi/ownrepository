package com.algorithm.sorting;

public class MergeSort extends AbstractSort{
	public MergeSort(int[] unsorted) {
		super(unsorted);
	}

	@Override
	protected void perform() {
		mergeSort(0, elements.length -1);
	}
	
	private void mergeSort(int left, int right) {
		if(left < right) {
			int middle = (left + right) / 2;
			
			mergeSort(left, middle);
			mergeSort(middle + 1, right);
			merge(left, middle, right);
		}
	}
	
	private void merge(int left, int middle, int right) {
		int[] leftTmp = new int[(middle - left) + 2];
		int[] rightTmp = new int[(right - middle) + 1];
		for (int i = 0, j = left; j <= middle;) {
			leftTmp[i++] = elements[j++];
		}
		for (int i = 0, j = middle + 1; j <= right;) {
			rightTmp[i++] = elements[j++];
		}

		leftTmp[(middle - left) + 1] = Integer.MAX_VALUE;
		rightTmp[right - middle] = Integer.MAX_VALUE;
		int i = 0, j = 0;
		for (int index = left; index <= right; index++) {
			if (leftTmp[i] < rightTmp[j]) {
				elements[index] = leftTmp[i++];
			} else {
				elements[index] = rightTmp[j++];
			}
		}
	}
	
	@Override
	protected String getSortName() {
		return "Merge Sort";
	}

}
