package com.pattern.structural.adapter.adaptee;

import com.pattern.structural.adapter.object.Volt;

public class Socket {
	public Volt getVolt() {
		return new Volt(120);
	}

}
