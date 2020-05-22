package com.pattern.creational.singleton;

public class EagerSingleton implements Cloneable{
	private static final EagerSingleton INSTANCE = new EagerSingleton();
	
	private EagerSingleton() {
	}
	
	public static EagerSingleton getInstance() {
		return INSTANCE;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
