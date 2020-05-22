package com.pattern.structural.bridge.devices;

import com.pattern.structural.bridge.Device;
import com.pattern.structural.bridge.TVApp;

public class Ipad extends Device {
	public Ipad(TVApp theApp) {
		super(theApp);
	}

	@Override
	public String playOn() {
		String app = super.playOn();
		return app + " on Ipad.";
	}

}
