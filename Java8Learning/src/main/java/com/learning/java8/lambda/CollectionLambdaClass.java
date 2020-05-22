package com.learning.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Product {
	Integer sku;
	String name;
	float price;
	
	Product(int sku, String name, float price) {
		this.sku = sku;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.name + " with sku no. " + this.sku + " is priced at " + this.price;
	}
}

public class CollectionLambdaClass {
	public static void main(String[] s) {
		List<Product> products = new ArrayList<Product>();
		
		products.add(new Product(5, "Printer", 97));
		products.add(new Product(2, "Catridge", 16));
		products.add(new Product(9, "Paper", 7));
		
		for(Product product : products) {
			System.out.println(product);
		}
		
		Collections.sort(products, (p1, p2) -> {
			return p1.sku.compareTo(p2.sku);
		});
		
		System.out.println("After sorting...");
		for(Product product : products) {
			System.out.println(product);
		}
	}

}

/*
 * Ways to use Comparator
 * 1. Create a concrete custom comparator class (that implements Comparator interface) and create instance of that class and pass that as parameter.
 * 2. Create a concrete custom comparator class and pass anonymous object of this class as a parameter.
 * 3. Create an anonymous object of the anonymous class (that implements Comparator interface) and pass that as parameter.
 * 4. Use lambda.
 */
