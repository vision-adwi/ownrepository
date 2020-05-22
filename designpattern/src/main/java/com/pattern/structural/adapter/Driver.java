package com.pattern.structural.adapter;

import com.pattern.structural.adapter.adaptee.Socket;
/*
Adapter pattern works as a bridge between two incompatible interfaces.
This pattern involves a single class which is responsible to join functionalities 
of independent or incompatible interfaces.
Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.
*/
public class Driver {

	public static void main(String[] args) {
		Socket socket = new Socket();
		System.out.println("Socket : " + socket.getVolt().value());
		
		SocketAdapter adapter = new SocketClassAdapterImpl();
		System.out.println("Socket(6V): " + adapter.get6Volt().value());
		
		adapter = new SocketObjectAdapterImpl();
		System.out.println("Socket(12V): " + adapter.get12Volt().value());
	}

}
