package com.pattern.structural.proxy;

import java.util.ArrayList;
import java.util.List;

public class BannedHosts {
	private static List<String> bannedHosts = new ArrayList<>();
	
	public static void registerBannedHost(String host) {
		bannedHosts.add(host);
	}
	
	public static boolean isBanned(String theHost) {
		boolean isBanned = false;
		
		for (String host : bannedHosts) {
			if(theHost.equals(host)) {
				isBanned = true;
			}
		}
		
		return isBanned;
	}

}
