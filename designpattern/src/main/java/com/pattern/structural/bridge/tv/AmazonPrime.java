package com.pattern.structural.bridge.tv;

import com.pattern.structural.bridge.TVApp;

public class AmazonPrime implements TVApp {
	@Override
	public String playOn() {
		return "AmazonPrime is running";
	}

}
