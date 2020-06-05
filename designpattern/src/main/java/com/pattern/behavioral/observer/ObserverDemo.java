package com.pattern.behavioral.observer;

import java.util.Scanner;

import com.pattern.behavioral.observer.concrete.BinObserver;
import com.pattern.behavioral.observer.concrete.HexObserver;
import com.pattern.behavioral.observer.concrete.OctObserver;
/*
Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified, 
its dependent objects are to be notified automatically.
*/
public class ObserverDemo {

	public static void main(String[] args) {
		Subject subject = new Subject();
		new HexObserver(subject);
		new OctObserver(subject);
		new BinObserver(subject);
		
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 5; i++) {
			System.out.print("Enter a number : ");
			subject.setState(scan.nextInt());
		}
		
		scan.close();

	}

}
