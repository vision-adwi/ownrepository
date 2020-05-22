package com.pattern.behavioral.state;

import com.pattern.behavioral.state.States.Closed;
import com.pattern.behavioral.state.States.Edit;
import com.pattern.behavioral.state.States.Opened;
import com.pattern.behavioral.state.States.Print;
import com.pattern.behavioral.state.States.Saved;
import com.pattern.behavioral.state.States.State;

public class FileController {
	State state;
	
	public FileController() {
		defineTransitions();
	}
	
	private void consume(Event transition) {
		State nextState = state.consume(transition);
		
		if (nextState != null) {
			state = nextState;
		}
	}
	
	private void transition(State from, Event event, State to) {
		from.define(event, to);
	}
	
	public void openFile() {
		consume(Event.OPEN);
	}
	
	public void editFile() {
		consume(Event.EDIT);
	}
	
	public void saveFile() {
		consume(Event.SAVE);
	}
	
	public void printFile() {
		consume(Event.PRINT);
	}
	
	public void closeFile() {
		consume(Event.CLOSE);
	}
	
	private void defineTransitions() {
		State closedState = Closed.getInstance();
		State openedState = Opened.getInstance();
		State editState = Edit.getInstance();
		State savedState = Saved.getInstance();
		State printState = Print.getInstance();
		
		transition(closedState, Event.OPEN, openedState);
		
		transition(openedState, Event.EDIT, editState);
		transition(openedState, Event.PRINT, printState);
		transition(openedState, Event.CLOSE, closedState);
		
		transition(editState, Event.SAVE, savedState);
		
		transition(savedState, Event.PRINT, printState);
		transition(savedState, Event.EDIT, editState);
		transition(savedState, Event.CLOSE, closedState);
		
		transition(printState, Event.CLOSE, closedState);
		transition(printState, Event.EDIT, editState);
		
		state = closedState;
	}

}
