package com.pattern.creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Driver {

	public static void main(String[] args) {
		breakSingletonByReflection();
		breakSingletonBySerializtion();
		breakSingletonByCloning();
		
		EnumSingleton instance = EnumSingleton.INSTANCE;

	}

	//Enum singleton is solution to this
	private static void breakSingletonByReflection() {
		EagerSingleton singleton1 = EagerSingleton.getInstance();
		EagerSingleton singleton2 = null;
		try {
			Constructor[] constructors = EagerSingleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				constructor.setAccessible(true);
				singleton2 = (EagerSingleton)constructor.newInstance();
				break;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Singleton broken by reflection - " + !(singleton1.hashCode() == singleton2.hashCode()));
	}
	
	private static void breakSingletonBySerializtion() {
		LazySingleton singleton1 = LazySingleton.getInstance();
		LazySingleton singleton2;

		try {
			ObjectOutput output = new ObjectOutputStream(new FileOutputStream("singleton.txt"));
			output.writeObject(singleton1);
			output.close();
			
			ObjectInput input = new ObjectInputStream(new FileInputStream("singleton.txt"));
			singleton2 = (LazySingleton)input.readObject();
			input.close();
			
			System.out.println("Singleton broken by serializtion - " + !(singleton1.hashCode() == singleton2.hashCode()));
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void breakSingletonByCloning() {
		EagerSingleton singleton1 = EagerSingleton.getInstance();
		try {
			EagerSingleton singleton2 = (EagerSingleton) singleton1.clone();
			System.out.println("Singleton broken by cloning - " + !(singleton1.hashCode() == singleton2.hashCode()));
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
