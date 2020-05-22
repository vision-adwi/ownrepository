package com.pattern.behavioral.memento;
/*
Memento is a behavioral design pattern that lets you save and restore the previous state
of an object without revealing the details of its implementation.
- Originator - Memento save() {...} void undo(Memento ) {...}
- Memento
- Caretaker - void save(Originator ) {...}  void undo(Originator ) {...}
*/
public class MementoDemo {
	public static void main(String[] str) {
		FileWriterCaretaker caretaker = new FileWriterCaretaker();
		FileWriteUtil editor = new FileWriteUtil("memento pattern",
				new StringBuilder("This"));

		System.out.println("Content: " + editor.toString());
		editor.write("is");
		System.out.println("Content: " + editor.toString());
		editor.write("a");
		System.out.println("Content: " + editor.toString());
		caretaker.save(editor); //Pointer
		editor.write("behavioral");
		System.out.println("Content: " + editor.toString());
		caretaker.save(editor); //Pointer
		editor.write("design");
		System.out.println("Content: " + editor.toString());
		System.out.println("Undo");
		caretaker.undo(editor);
		System.out.println("Content: " + editor.toString());
		caretaker.undo(editor);
		System.out.println("Content: " + editor.toString());
	}

}
