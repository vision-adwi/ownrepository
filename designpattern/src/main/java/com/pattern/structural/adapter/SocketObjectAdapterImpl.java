package com.pattern.structural.adapter;

import com.pattern.structural.adapter.adaptee.Socket;
import com.pattern.structural.adapter.object.Volt;

public class SocketObjectAdapterImpl implements SocketAdapter {
	private Socket adapteeSocket = new Socket();

	@Override
	public Volt get120Volt() {
		return adapteeSocket.getVolt();
	}

	@Override
	public Volt get12Volt() {
		Volt volt = adapteeSocket.getVolt();
		return convertVolt(volt, 10);
	}

	@Override
	public Volt get6Volt() {
		Volt volt = adapteeSocket.getVolt();
		return convertVolt(volt, 20);
	}
	
	private Volt convertVolt(Volt volt, int i) {
		return new Volt(volt.value()/i);
	}

}
