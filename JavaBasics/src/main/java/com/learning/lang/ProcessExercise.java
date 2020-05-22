package com.learning.lang;

import java.io.IOException;

public class ProcessExercise {

	public static void main(String[] args) throws IOException, InterruptedException {
		//ProcessBuilder builder = new ProcessBuilder("notepad.exe");
		 
		//Process theProcess = builder.start();
		Process theProcess = Runtime.getRuntime().exec("notepad.exe");
		
		Thread.sleep(10 * 1000);
		theProcess.destroy();
		runtimeInfo();

	}
	
	private static void runtimeInfo() {
		System.out.println("Available processors : " + Runtime.getRuntime().availableProcessors());
		System.out.println("Free memory          : " + Runtime.getRuntime().freeMemory());
		System.out.println("Max memory           : " + Runtime.getRuntime().maxMemory());
		System.out.println("Total memory         : " + Runtime.getRuntime().totalMemory());
	}
	
	private static void registerShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Program is exiting");
			}
		});
	}

}
