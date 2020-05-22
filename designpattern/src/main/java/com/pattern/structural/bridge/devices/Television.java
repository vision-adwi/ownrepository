package com.pattern.structural.bridge.devices;

import com.pattern.structural.bridge.Device;
import com.pattern.structural.bridge.TVApp;

public class Television extends Device {
	public Television(TVApp theApp) {
		super(theApp);
	}

	@Override
	public String playOn() {
		String app = super.playOn();
		return app + " on Television.";
	}
}
