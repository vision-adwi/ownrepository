package com.learning.util.collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		SingleDimensionArray theArray = new SingleDimensionArray();
		
		theArray.instatantiate(1000000);
		theArray.initialize(500);
		/*List<Integer> list = new ArrayList<>();

		addItems(list, 1000000);
		insertItem(list, 95000, 12000);
		deleteItem(list, 900);
		toArray(list);*/

	}

	private static void addItems(List<Integer> list, long numberOfItems) {
		Long startTime = System.nanoTime();
		for (Integer i = 0; i < numberOfItems; i++) {
			list.add(i);
		}
		Long endTime = System.nanoTime();
		System.out.println("Difference - " + (endTime - startTime) / 1000);
	}
	
	private static void insertItem(List<Integer> list, int index, int item) {
		Long startTime = System.nanoTime();
		list.add(index, item);
		Long endTime = System.nanoTime();
		System.out.println("Difference - " + (endTime - startTime) / 1000);
	}
	
	private static void deleteItem(List<Integer> list, int index) {
		Long startTime = System.nanoTime();
		list.remove(index); 
		Long endTime = System.nanoTime();
		System.out.println("Difference - " + (endTime - startTime) / 1000);
	}
	
	private static void toArray(List<Integer> list) {
		Long startTime = System.nanoTime();
		Object[] arrayList = list.toArray();
		Long endTime = System.nanoTime();
		System.out.println("Difference - " + (endTime - startTime) / 1000);
	}

}
