package com.learning.java5.concurrency.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CartService {
	public static void main(String[] s) throws InterruptedException, ExecutionException {
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		
		int size = 25;
		Cart[] carts = new Cart[size];
		createCarts(carts, size);
		
		for (Cart cart:carts) {
			CompletableFuture.supplyAsync(() -> squareOf(cart))
								.thenApply((decoratedCart) -> numConversion(decoratedCart))
								.thenApply((numberName) -> countCharacter(numberName))
								.thenApply((count) -> concatenateResult(cart, count))
								.thenAccept((value) -> System.out.println(value));
								
								
		}
									
/*
		List<Future<Cart>> squareFutures = new ArrayList<>();
		for (Cart cart:carts) {
			Future<Cart> squareFuture = threadPool.submit(() -> squareOf(cart)); //submit() is not a blocking call
			squareFutures.add(squareFuture);
		}
		System.out.println("All tasks submitted(for square)...");
		
		List<Future<String>> numNameFutures = new ArrayList<>();
		for(Future<Cart> future : squareFutures) {
			Cart decoratedCart = future.get(); //get() is a blocking call
			Future<String> nameFuture = threadPool.submit(() -> numConversion(decoratedCart));
			numNameFutures.add(nameFuture); 
		}
		System.out.println("All tasks submitted(for conversion)...");
		
		List<Future<Integer>> countFutures = new ArrayList<>();
		for(Future<String> future : numNameFutures) {
			String numberName = future.get(); //get() is a blocking call
			Future<Integer> countFuture = threadPool.submit(() -> countCharacter(numberName));
			countFutures.add(countFuture); 
		}
		System.out.println("All tasks submitted(for count)...");
		
		List<Future<String>> finalResults = new ArrayList<>();
		for(int i = 0; i < size; i++) {
			Integer count = countFutures.get(i).get();
			Cart theCart = carts[i];
			Future<String> finalResult = threadPool.submit(() -> concatenateResult(theCart, count));
			finalResults.add(finalResult);
		}
		System.out.println("All tasks submitted(for final result)...");
		
		for(Future<String> future : finalResults) {
			System.out.println(future.get());
		}
		*/
	}

	private static void createCarts(Cart[] carts, int size) {
		for (int i = 0; i < size; i++) {
			Cart cart = new Cart(Cart.getAndIncrement());
			carts[i] = cart;
		}
	}
	
	private static Cart squareOf(Cart theCart) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int num = theCart.getCartNo();		
		theCart.setSquare((num * num));
		
		return theCart;
	}
	
	private static String numConversion(Cart theCart) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int num = theCart.getSquare();		

		return NumToStringConversion.convert(num);
	}
	
	private static Integer countCharacter(String numName) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return numName.length();
	}
	
	private static String concatenateResult(Cart cart, Integer count) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return cart.getSquare() + " : " + count;
	}

}

