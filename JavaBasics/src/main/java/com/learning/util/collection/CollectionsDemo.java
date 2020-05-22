package com.learning.util.collection;

import java.util.ArrayList;
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
		List<String> theList = new ArrayList<>();
		theList.add("Ram");
		theList.add("Shyam");
		theList.add("Kanha");
		
		
		List<String> synchronizedList = Collections.synchronizedList(theList);
		
		List<String> unmodifiableList = Collections.unmodifiableList(theList);
		//unmodifiableList.add("Ghanshyam");

		Collections.sort(theList);
		System.out.println(theList);
		System.out.println(unmodifiableList);
		
		Collections.reverse(theList);
		System.out.println(theList);
		
		hashTableSort();
		hashSetSort();

	}
	
	public static void hashTableSort() {
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
