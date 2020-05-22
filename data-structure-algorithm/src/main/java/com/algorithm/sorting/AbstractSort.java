package com.algorithm.sorting;

public abstract class AbstractSort {
	protected int[] elements;

	protected AbstractSort(int[] unsorted) {
		elements = unsorted.clone();
	}

	public int[] sort() {
		long start = System.nanoTime();

		perform();

		long end = System.nanoTime();
		float timeTaken = (end - start) / 1000f;
		System.out.println(getSortName() + ":(" + timeTaken + " milliseconds)");

		return elements;
	}

	abstract protected void perform();

	abstract protected String getSortName();

}
