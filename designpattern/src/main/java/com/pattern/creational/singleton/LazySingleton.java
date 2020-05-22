package com.pattern.creational.singleton;

import java.io.Serializable;

public class LazySingleton implements Serializable{
	private static final long serialVersionUID = -8608446721460668370L;
	private static LazySingleton object;
	
	private LazySingleton() {
	}
	
	public static LazySingleton getInstance() {
		if (null == object) {
			object = new LazySingleton();
		}
		
		return object;
	}
	
	//This method should be added to protect the integrity of Singleton which is vulnerable
	//to be broken during deserialization.
	protected Object readResolve() {
		return object;
	}

}
