package com.pattern.structural.adapter.object;

public class Volt {
	private int volts;
	
	public Volt(int theVolts) {
		volts = theVolts;
	}

	public int value() {
		return volts;
	}

	public void setVolts(int volts) {
		this.volts = volts;
	}

}
