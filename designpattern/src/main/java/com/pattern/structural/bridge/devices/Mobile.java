package com.pattern.structural.bridge.devices;

import com.pattern.structural.bridge.Device;
import com.pattern.structural.bridge.TVApp;
//Refined Abstraction
public class Mobile extends Device {
	public Mobile(TVApp theApp) {
		super(theApp);
	}

	@Override
	public String playOn() {
		String app = super.playOn();
		return app + " on Mobile.";
	}
}
