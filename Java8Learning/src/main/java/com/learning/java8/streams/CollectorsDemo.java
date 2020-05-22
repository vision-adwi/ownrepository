package com.learning.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<Product>();

		products.add(new Product(1, "HP Laptop", 25000f));
		products.add(new Product(2, "Dell Laptop", 30000f));
		products.add(new Product(3, "Lenevo Laptop", 28000f));
		products.add(new Product(4, "Sony Laptop", 28000f));
		products.add(new Product(5, "Apple Laptop", 90000f));
		
		collect(products);
	}
	
	/*
	 - averaging
	 - collectingAndThen
	 - counting
	 - groupingBy
	 - joining
	 - mapping
	 - maxBy
	 - minBy
	 - partitioningBy
	 - reducing
	 - summarizing
	 - summing
	 - toCollection
	 - toConcurrentMap
	 - toList
	 - toSet
	 - toMap
	*/
	
	private static void collect(List<Product> products) {
		Double averagePrice = products.stream().collect(Collectors.averagingDouble(p -> p.price));
		System.out.println("Average Price - " + averagePrice);
		
		Integer sumOfId = products.stream().collect(Collectors.summingInt(p -> p.id));
		System.out.println("Id summation - " + sumOfId);

		Long countOfItems = products.stream().collect(Collectors.counting());
		System.out.println("Total no of products - " + countOfItems);
		
		Stream<Product> filteredStream = products.stream().filter(p -> p.price > 30000);
		List<Product> productList = filteredStream.collect(Collectors.toList());
		System.out.println("Product list<list> - " + productList);
		
		filteredStream = products.stream().filter(p -> p.price > 28000);
		Set<Product> productSet = filteredStream.collect(Collectors.toSet());
		System.out.println("Product list<set> - " + productSet);
	}

}
