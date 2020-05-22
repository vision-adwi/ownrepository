package com.learning.java5.generics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EntryGenericsTest {

	public static void main(String[] args) {
		Map<Integer, String> theMap = new HashMap<Integer, String>();
		
		theMap.put(1, "One");
		theMap.put(2, "Two");
		theMap.put(3, "Three");
		
		Set<Entry<Integer,String>> theSet = theMap.entrySet();
		
		System.out.println("***** For - Each ****");
		for(Entry<Integer,String> theEntry : theSet)
		{
			System.out.println(theEntry.getKey() + " " + theEntry.getValue());
		}
		
		System.out.println("**** Conventional ****");
		Iterator<Entry<Integer,String>> theIterator = theSet.iterator();
		while(theIterator.hasNext())
		{
			Entry<Integer,String> theEntry = theIterator.next();
			System.out.println(theEntry.getKey() + " " + theEntry.getValue());
		}
	}

}
/*
Advantage of Java Generics
1) Type-safety
2) Type casting is not required
3) Compile-Time Checking
*/
