package com.pattern.behavioral.memento;
/*
Caretaker class
*/
public class FileWriterCaretaker {
	Stack memory = new Stack();
	
	public void save(FileWriteUtil editor) {
		memory.push(editor.save());
	}
	
	public void undo(FileWriteUtil editor) {
		Object obj = memory.pop();
		
		if(obj!=null) {
			editor.undoToLastSave(obj);
		}
	}

}
