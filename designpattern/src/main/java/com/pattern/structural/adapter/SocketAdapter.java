package com.pattern.structural.adapter;

import com.pattern.structural.adapter.object.Volt;

public interface SocketAdapter {
	public Volt get120Volt();
	public Volt get12Volt();
	public Volt get6Volt();

}
