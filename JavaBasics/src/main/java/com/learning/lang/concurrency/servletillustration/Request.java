package com.learning.lang.concurrency.servletillustration;

public class Request {
	private String requester;
	public Request(String requester) {
		this.requester = requester;
	}
	
	public String getRequester() {
		return this.requester;
	}

}
