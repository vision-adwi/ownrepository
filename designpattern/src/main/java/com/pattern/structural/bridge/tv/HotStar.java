package com.pattern.structural.bridge.tv;

import com.pattern.structural.bridge.TVApp;

public class HotStar implements TVApp {
	@Override
	public String playOn() {
		return "HotStar is running";
	}

}
