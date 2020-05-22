package com.pattern.behavioral.state.States;

import java.util.HashMap;
import java.util.Map;

import com.pattern.behavioral.state.Event;

public abstract class State {
	private Map<Event, State> transitions;

	protected State() {
		transitions = new HashMap<>();
	}

	public State consume(Event transition) {
		State nextState = transitions.get(transition);
		if (nextState != null) {
			System.out.println(nextState.stateMessge());
		} else {
			System.out.println("File can not be " + transition.getValue()
					+ " from this state.");
		}
		return nextState;
	}

	public void define(Event transition, State state) {
		transitions.put(transition, state);
	}

	public abstract String stateMessge();

}
