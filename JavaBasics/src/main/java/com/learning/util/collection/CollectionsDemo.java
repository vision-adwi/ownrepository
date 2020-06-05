package com.learning.util.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionsDemo {

	public static void main(String[] args) {
		List<String> theList = Arrays.asList("Ram", "Shyam", "Kanha");

		List<String> synchronizedList = Collections.synchronizedList(theList);
		System.out.println("1. synchronizedList - " + synchronizedList);
		
		Collections.swap(synchronizedList, 1, 2);
		System.out.println("2. after swap()     - " + synchronizedList);
		
		List<String> unmodifiableList = Collections.unmodifiableList(theList);		//It provides collection with read only features
		//unmodifiableList.add("Ghanshyam"); //This will throw java.lang.UnsupportedOperationException

		Collections.sort(theList);
		System.out.println(theList);
		System.out.println(unmodifiableList);
		
		Collections.reverse(theList);
		System.out.println(theList);
		
		List<Float> singletonList = Collections.singletonList(5.6f);
		
		hashMapSort();
		hashSetSort();

	}
	
	public static void hashMapSort() {
		Map<Integer, String> hashMap = new HashMap<>();

		hashMap.put(18, "Eighteen");
		hashMap.put(20, "Twenty");
		hashMap.put(5, "Five");
		hashMap.put(3, "Three");
		hashMap.put(9, "Nine");
		hashMap.put(1, "One");

		for (Entry<Integer, String> pair : hashMap.entrySet()) {
			System.out.println(pair.getKey() + " " + pair.getValue());
		}

		TreeMap<Integer, String> treeMap = new TreeMap<>(hashMap);

		System.out.println("\nSorted ***************\n");
		for (Entry<Integer, String> pair : treeMap.entrySet()) {
			System.out.println(pair.getKey() + " " + pair.getValue());
		}

	}
	
	public static void hashSetSort() {
		Set<Integer> hashSet = new HashSet<>();

		hashSet.add(18);
		hashSet.add(20);
		hashSet.add(5);
		hashSet.add(3);
		hashSet.add(9);
		hashSet.add(1);

		for (Integer data : hashSet) {
			System.out.print(data + " ");
		}

		TreeSet<Integer> treeSet = new TreeSet<>(hashSet);

		System.out.println("\nSorted ***************");
		for (Integer data : treeSet) {
			System.out.print(data + " ");
		}

	}

}
