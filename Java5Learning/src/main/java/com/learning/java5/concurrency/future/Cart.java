package com.learning.java5.concurrency.future;

public class Cart {
	private static int cartSeq;
	private int cartNo;
	private int square;
	
	public static int getAndIncrement() {
		return ++cartSeq;
	}
	
	public Cart(int cartNo) {
		this.cartNo = cartNo;
	}
	
	public int getCartNo() {
		return this.cartNo;
	}
	
	public void setSquare(int theSquare) {
		this.square = theSquare;
	}
	
	public int getSquare() {
		return this.square;
	}

	@Override
	public String toString() {
		return "Cart [cartNo=" + cartNo + ", square=" + square + "]";
	}
	
	

}
