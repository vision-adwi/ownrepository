package com.pattern.behavioral.state.States;

public class Saved extends State {
	private static State INSTANCE;

	private Saved() {
	}
	
	public static State getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Saved();
		}
		return INSTANCE;
	}
	@Override
	public String stateMessge() {
		return "File is saved.";
	}
}
