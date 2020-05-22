package com.pattern.structural.bridge.tv;

import com.pattern.structural.bridge.TVApp;

public class ZeePlus implements TVApp {
	@Override
	public String playOn() {
		return "Zee+ is running";
	}
}
