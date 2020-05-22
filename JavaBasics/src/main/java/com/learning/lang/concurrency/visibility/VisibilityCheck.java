package com.learning.lang.concurrency.visibility;

public class VisibilityCheck {

	public static void main(String[] args) {
		ReaderWriter console = new ReaderWriter();
		new Thread(() -> console.write()).start();
		new Thread(() -> console.read()).start();

	}

}
