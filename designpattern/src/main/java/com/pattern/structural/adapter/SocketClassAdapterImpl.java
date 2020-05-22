package com.pattern.structural.adapter;

import com.pattern.structural.adapter.adaptee.Socket;
import com.pattern.structural.adapter.object.Volt;

public class SocketClassAdapterImpl extends Socket implements SocketAdapter {

	@Override
	public Volt get120Volt() {
		return getVolt();
	}

	@Override
	public Volt get12Volt() {
		Volt volt = getVolt();
		return convertVolt(volt, 10);
	}

	@Override
	public Volt get6Volt() {
		Volt volt = getVolt();
		return convertVolt(volt, 20);
	}
	
	private Volt convertVolt(Volt volt, int i) {
		return new Volt(volt.value()/i);
	}

}
