package com.pattern.behavioral.state;

public enum Event
{
	OPEN("opened"), CLOSE("closed"), EDIT("edited"), SAVE("saved"), PRINT("printed");
	
	String transitionMsg;
	
	Event(String msg) {
		transitionMsg = msg;
	}
	
	public String getValue() {
		return transitionMsg;
	}

}
