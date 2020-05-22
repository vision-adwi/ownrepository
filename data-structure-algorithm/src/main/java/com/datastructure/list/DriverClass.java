package com.datastructure.list;


public class DriverClass {

	public static void main(String[] args) {
		singleLinkedList();
		doubleLinkedList();

	}

	private static void doubleLinkedList() {
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList("Row");

		doubleLinkedList.traverse();
		System.out.println("*********");

		doubleLinkedList.insert("Row", 0);
		doubleLinkedList.traverse();
		System.out.println("*********");

		doubleLinkedList.insert("Your", 2);
		doubleLinkedList.traverse();
		System.out.println("*********");

		doubleLinkedList.insert("Row", 2);
		doubleLinkedList.traverse();
		System.out.println("*********");

		doubleLinkedList.insert("Boat", 60);
		doubleLinkedList.traverse();
		System.out.println("*********");

		doubleLinkedList.insert("Gently", 5);
		doubleLinkedList.traverse();
		System.out.println("*********");

		System.out.println("Element 'Your' is found at position - "
				+ doubleLinkedList.search("Your"));

		// doubleLinkedList.delete(5);
		doubleLinkedList.traverse();
		System.out.println("*********");

		doubleLinkedList.delete(6);
		doubleLinkedList.traverse();
		System.out.println("*********");

		doubleLinkedList.traverseBackward();
	}
	
	private static void singleLinkedList() {
		  SingleLinkedList list = new SingleLinkedList(); 
		  list.traverse();
		  System.out.println("*********");
		  list.insert("Had");
		  list.insert("little"); list.traverse();
		  System.out.println("*********");
		  
		  list.insert("a", 1); list.traverse();
		  System.out.println("*********");
		  
		  list.insert("Marry"); //list.traversal();
		  
		  list.insert("lamb", 4); list.traverse();
		  
		  System.out.println("******Delete******"); list.delete(4);
		  list.traverse();
		  
		  CircularSingleLinkedList circularList = new
		  CircularSingleLinkedList("Row"); circularList.traverse();
		  System.out.println("*********");
		  
		  circularList.insert("Row", 0); circularList.traverse();
		  System.out.println("*********");
		  
		  circularList.insert("Your", 2); circularList.traverse();
		  System.out.println("*********");
		  
		  circularList.insert("Row", 2); circularList.traverse();
		  System.out.println("*********");
		  
		  circularList.insert("Boat", 6); circularList.traverse();
		  System.out.println("*********");
		  
		  circularList.insert("Gently", 5); circularList.traverse();
		  System.out.println("*********");
		  
		  System.out.println("Element 'Your' is found at position - " +
		  circularList.search("Hi"));
		  
		  circularList.delete(5); circularList.traverse();
		  System.out.println("*********");
		  
		  circularList.delete(1); circularList.traverse();
		  System.out.println("*********");
		 
	}

}
