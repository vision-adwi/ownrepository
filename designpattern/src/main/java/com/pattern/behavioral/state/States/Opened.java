package com.pattern.behavioral.state.States;

public class Opened extends State {
	private static State INSTANCE;

	private Opened() {
	}

	public static State getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Opened();
		}
		return INSTANCE;
	}
	@Override
	public String stateMessge() {
		return "File is opened.";
	}
}
