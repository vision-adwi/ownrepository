package com.pattern.structural.proxy;
/*
- Provide a surrogate or placeholder for another object to control access to it.
- Use an extra level of indirection to support distributed, controlled, or intelligent access.
- Add a wrapper and delegation to protect the real component from undue complexity.
*/
public class Client {

	public static void main(String[] args) {
		BannedHosts.registerBannedHost("www.bangok.com");
		BannedHosts.registerBannedHost("www.curvy.com");
		
		Internet connect = new InternetProxy();
		connect.connect("www.ibnlive.com");
		connect.connect("www.curvy.com");

	}

}
