package com.pattern.behavioral.state;
/*
In State pattern a class behavior changes based on its state.
*/
public class StateDemo {

	public static void main(String[] args) {
		FileController controller = new FileController();
		
		//controller.closeFile();
		controller.editFile();
		controller.openFile();
		controller.editFile();
		controller.saveFile();
		controller.closeFile();
		controller.printFile();
		controller.closeFile();
	}

}
