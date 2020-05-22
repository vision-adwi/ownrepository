package com.pattern.behavioral.state.States;

public class Closed extends State {
	private static State INSTANCE;

	private Closed() {
	}
	
	public static State getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Closed();
		}
		return INSTANCE;
	}

	@Override
	public String stateMessge() {
		return "File is closed now.";
	}
}
