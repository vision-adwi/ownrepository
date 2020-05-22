package com.learning.java8.methodreference;

interface Messageable {
	Message getMessage(String str);
}

class Message {
	Message(String msg) {
		System.out.println(msg);
	}
}

public class ConstructorReferenceDemo {

	public static void main(String[] args) {
		//Conventional way - before jave 8
		Messageable messageable = new Messageable() {
			public Message getMessage(String str) {
				return new Message(str);
			}
		};
		
		messageable.getMessage("Conventional way - before java 8 ");
		
		//Lambda - after jave 8
		Messageable messageable1 = str -> new Message(str);
		messageable1.getMessage("Lambda - after jave 8 ");
		
		//Constructor reference - after jave 8
		Messageable messageable2 = Message::new;
		messageable2.getMessage("Constructor reference - after jave 8 ");

	}

}
