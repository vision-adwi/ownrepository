package com.pattern.structural.proxy;

public class InternetProxy implements Internet {
	@Override
	public void connect(String host) {
		if (!BannedHosts.isBanned(host)) {
			new InternetImpl().connect(host);
		}

	}

}
