package com.practice.tricky;

public class Tricky1 {

	public static void main(String[] args) {
		Infinity _instance = new Infinity();

	}

}

class Infinity {
	Infinity infinity = new Infinity();
}

//Justification - This will create infinite object graph and causes for StackOverflowError
