package com.learning.java8.methodreference;

@FunctionalInterface
interface Demonstrate {
	void showUp();
}

class TheatricalShow {
	void play() {
		System.out.println("Lights...");
		System.out.println("Raise...");
		System.out.println("Go...");
	}
}

public class MethodReferenceDemo {
	public static void main(String[] s) {
		System.out.println("******* Video Shoot ********");
		Demonstrate videoShoot = MethodReferenceDemo::shoot;
		//Above definition is similar to this
		/*
		Demonstrate videoShoot = new Demonstrate() {
			@Override
			public void showUp() {
				MethodReferenceDemo.shoot();
			}
		};
		*/
		videoShoot.showUp();

		System.out.println("\n******* Mike Check ********");
		Demonstrate mikeCheck = () -> System.out.println("Check.. check.. check..");
		mikeCheck.showUp();
		
		System.out.println("\n******* Sound Recording ********");
		Demonstrate recording = () -> {
			System.out.println("Sound check.");
			System.out.println("Record...");
		};
		recording.showUp();
		
		System.out.println("\n******* Theatrical Show ********");
		Demonstrate drama = new TheatricalShow()::play;
		drama.showUp();
	}

	static void shoot() {
		System.out.println("Light...");
		System.out.println("Camera...");
		System.out.println("Action...");
	}

}
