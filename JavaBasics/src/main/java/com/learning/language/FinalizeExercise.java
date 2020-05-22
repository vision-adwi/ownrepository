package com.learning.language;
/*
It is supposed to give the last chance to the object to do cleanup or resurrect itself, 
but the main problem is that it's not guaranteed to be called.
*/
public class FinalizeExercise {

	public static void main(String[] args) {
		Container container = new Container();
		Containee containee = new Containee(container);
		containee = null;	//1. This makes it eligible to be garbage collected.
		container.clearContainee(); //3. containee will not be eligible to be garbage collection
		                            //   again until container holds it.

	}

}
class Container {
	Containee containee;
	
	public void setContainee(Containee theContainee) {
		this.containee = theContainee;
	}
	
	public void clearContainee() {
		this.containee = null;
	}
}

class Containee {
	Container container;
	public Containee(Container theContainer) {
		this.container = theContainer;
	}
	
	//4. finalize() method on the same object would not be called again(one time calling)
	@Override
	public void finalize() {
		container.setContainee(this);  //2. Now the object is resurrect again and set in the container object.
	}
	
}
