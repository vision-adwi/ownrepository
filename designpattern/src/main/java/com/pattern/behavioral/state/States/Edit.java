package com.pattern.behavioral.state.States;

public class Edit extends State {
	private static State INSTANCE;

	private Edit() {
	}
	
	public static State getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Edit();
		}
		return INSTANCE;
	}
	@Override
	public String stateMessge() {
		return "File is being edited now.";
	}
}
