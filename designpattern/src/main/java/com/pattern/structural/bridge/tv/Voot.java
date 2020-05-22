package com.pattern.structural.bridge.tv;

import com.pattern.structural.bridge.TVApp;

public class Voot implements TVApp {
	@Override
	public String playOn() {
		return "Voot is running";
	}
}
