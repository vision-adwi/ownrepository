package com.practice.tricky;

public class Tricky13 {
	public static void main(String[] s) {
		Thread t = new MyThread() {
			public void run() {
				System.out.print(" Duper");
			}
		};
		
		t.start();
	}

}

class MyThread extends Thread {
	MyThread() {
		System.out.print(" Super");
	}
	
	public void run() {
		System.out.print(" Doodle");
	}
}
