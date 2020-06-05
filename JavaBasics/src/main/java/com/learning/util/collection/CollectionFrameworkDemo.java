package com.learning.util.collection;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class CollectionFrameworkDemo {

	public static void main(String[] args) {
		//java_1_0();
		//java_1_2();
		//enumerationTest();
		//hashSetTest();
		

	}
	
	private static void java_1_0() {
		//All methods are synchronized by nature
		vectorTest();
		hashtableTest();
		stackTest();
		propertiesTest();
		enumerationTest();
	}
	
	private static void java_1_2() {
		//Methods are not synchronized by nature
		arrayListTest();
		linkedListTest();
		
		hashMapTest();
		treeMapTest();
		
		hashSetTest();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void hashtableTest() {
		// Initial capacity 11 and load factor 0.75
		// null as a key or value is not allowed
		Hashtable hashtable = new Hashtable();
		
		hashtable.put(1, "one");
		hashtable.put(2, "two");
		//hashtable.put(5, null);
		System.out.println(hashtable.get(1));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void vectorTest() {
		//Default initial capacity is 10.
		Vector vector = new Vector();

		vector.add(10);								//1. add
		vector.addElement(20);
		vector.add(1, 30);							//2. insert
		System.out.println(vector.size());			//3. count
		System.out.println(vector.contains(10));	//4. search
		vector.set(1, 50);							//5. replace
		System.out.println(vector.get(2));	     	//6. retrieve
		vector.remove(0);							//7. delete
	}
	
	private static void stackTest() {
		Stack stack = new Stack();

		stack.push(10);
		stack.push(20);

		stack.pop();
	}
	
	private static void propertiesTest() {
		//Properties class is used to read properties from external files or 
		//load properties from Xml files. It provided below new method to just
		//pass key/value pair as String/String
		Properties properties = new Properties();

		properties.setProperty("Key1", "Value1");
	}
	
	private static void enumerationTest() {
		Hashtable hashtable = new Hashtable();

		hashtable.put(1, "One");
		hashtable.put(2, "two");
		hashtable.put(3, "three");

		Enumeration valuesEnum = hashtable.elements();
		while (valuesEnum.hasMoreElements()) {
			System.out.println(valuesEnum.nextElement());
		}
		
		Enumeration keysEnum = hashtable.keys();
		while (keysEnum.hasMoreElements()) {
			System.out.println(keysEnum.nextElement());
		}
	}
	
	private static void arrayListTest() {
		//Default initial size is 0
		ArrayList list = new ArrayList();

		list.add(500);
		list.add(700);
		list.add(800);
		System.out.println(list.get(0));
		list.remove(0);
		
		list.forEach(System.out::println);
		
		//Conversion of List to array
		Object[] objects = list.toArray();

		//Conversion of List to Set
		Set newSet = new HashSet(list);
	}
	
	public static void linkedListTest() {
		LinkedList linkedList = new LinkedList();
		
		linkedList.add("This");
		linkedList.add(0, "is");
		linkedList.iterator();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void hashMapTest() {
		HashMap map = new HashMap();
		
		System.out.println("Size: " + map.size() + " Empty? " + map.isEmpty());
		map.put(1, "One");							//1. Add
		map.put(2, "Two");
		map.put(9, "Four");
		map.put(null, "Five"); //Allows null as key or null as a value
		System.out.println("Size: " + map.size() + " Empty? " + map.isEmpty());
		
		map.replace(9, "Nine");
		//map.remove(9);
		System.out.println(map.get(2));				//2. Retrieve
		System.out.println(map.containsKey(2));		//3. Search
		System.out.println(map.containsValue("Two"));	
		
		Set set = map.keySet();
		Iterator theIterator = set.iterator();
		while(theIterator.hasNext()) {
			System.out.println(theIterator.next());
		}
		
		Set entrySet = map.entrySet();
		theIterator = entrySet.iterator();
		while(theIterator.hasNext()) {
			Entry entry = (Entry)theIterator.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		map.clear();
	}
	
	public static void treeMapTest() {
		TreeMap map = new TreeMap();
		
		map.put(5, "Five");
		map.put(7, "Seven");
		

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void hashSetTest() {
		HashSet<Integer> set = new HashSet<>();
		System.out.println("Size: " + set.size() + " Empty? " + set.isEmpty());
		set.add(10);
		set.add(50);
		System.out.println("Contains key 10? " + set.contains(10));
		set.remove(50);
		set.add(20);
		
		//Conversion from Set to array
		Integer[] objects = (Integer[])set.toArray();
		
		//Another way
		set.toArray(objects);
		for(Object data:objects) {
			System.out.print(data + " ");
		}
		
		//Conversion from Set to List
		List list = new ArrayList(set);
	}
	
	public static void treeSetTest() {
		TreeSet set = new TreeSet();
		
	}

}
