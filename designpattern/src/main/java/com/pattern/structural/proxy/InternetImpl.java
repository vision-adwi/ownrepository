package com.pattern.structural.proxy;

public class InternetImpl implements Internet {

	@Override
	public void connect(String host) {
		System.out.println("Connecting to host - " + host);

	}

}
