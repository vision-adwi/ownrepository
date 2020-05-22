package com.pattern.structural.bridge.tv;
import com.pattern.structural.bridge.TVApp;
//Concrete Implementation
public class SonyLIV implements TVApp {
	@Override
	public String playOn() {
		return "SonyLIV is running";
	}
}
