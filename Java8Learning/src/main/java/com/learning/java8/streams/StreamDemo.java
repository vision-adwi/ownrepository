package com.learning.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Product {
	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public String toString() {
		return "Product code - " + id + " Product name - " + name + " priced at - " + price;
	}
}

public class StreamDemo {

	public static void main(String[] args) {
		List<Product> productsList = new ArrayList<Product>();

		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));

		//conventionalWay(productsList);
		predicate(productsList);
		map(productsList);

	}
	
	private static void map(List<Product> productsList) {
		Stream<String> productNames = productsList.stream().map(p -> p.name);
		productNames.forEach(p -> System.out.println(p));

		IntStream ids = productsList.stream().mapToInt(p -> p.id);
		ids.forEach(a -> System.out.println(a));
		
		//productsList.stream()
	}
	
	private static void predicate(List<Product> productsList) {
		//Below is the intermediate operation which will be performed when the elements of 
		//stream will be consumed.
		Stream<Product> peek = productsList.stream().peek(System.out::println);
		
		//consume
		boolean allMatch = peek.allMatch(x -> x.price > 24000);
		System.out.println("All items price is more than 24000?: " + allMatch);
		
		//consume
		boolean anyMatch = productsList.stream().anyMatch(x -> x.price < 25000);
		System.out.println("Any item is less than 25000?: " + anyMatch);

		//process
		Stream<Product> filteredStream = productsList.stream().filter(p -> p.price > 28000);
		filteredStream.forEach(z -> {
			System.out.println("Item: " + z.name + " Price: " + z.price);
		});
		
		
		//productsList.stream().
		
	}
	
	private static void conventionalWay(List<Product> productsList) {
		Stream<Product> productStream = productsList.stream();
		Stream<Product> filteredStream = productStream.filter(new Predicate<Product>() {
					@Override
					public boolean test(Product p) {
						return p.price > 28000;
					}
				});
		filteredStream.forEach(new Consumer<Product>() {
			@Override
			public void accept(Product p) {
				System.out.println(p);
			}
		});
		
		productStream = productsList.stream();
		Stream<String> productNames = productStream.map(new Function<Product, String>() {
			@Override
			public String apply(Product t) {
				return t.name;
			}
		});
		productNames.forEach(System.out::println);
	}

}
