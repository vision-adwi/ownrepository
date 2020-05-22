package com.practice.tricky;

import java.util.HashSet;
import java.util.Set;

public class Tricky10 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(10);
		set.add(20);
		System.out.println(set);
		
		Set<Integer> set1 = new HashSet<Integer>() { //Anonymous class is created
			//This is the block
			{
				add(50);
				add(100);
			}
		};
		System.out.println(set1);

	}

}
//Justification - Here a new anonymous sub-class of HashSet is created. In that class the non-static
//block is there from where the add method is called.
