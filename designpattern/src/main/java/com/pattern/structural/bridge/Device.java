package com.pattern.structural.bridge;
//Abstraction
public abstract class Device {
	private TVApp app;
	
	protected Device(TVApp theApp) {
		this.app = theApp;
	}
	
	protected String playOn() {
		return app.playOn();
	}

}
