package com.learning.io.streams.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KeyboardInput {

	public static void main(String[] args) throws IOException {
		//consoleReadTest();

	}
	
	private static void scannerTest() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Take input from keyboard: ");
		String input = scanner.nextLine();
		System.out.println("Input taken from keyboard is - " + input);
		
		scanner.close();
	}
	
	private static void bufferedReaderTest() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.print("Take input from keyboard: ");
		String input = reader.readLine();
		System.out.println("Input taken from keyboard is - " + input);
	}
	
	//Will not work with non-intelligent system like IDE
	private static void consoleReadTest() {
		System.out.print("Take input from keyboard: ");
		String input = System.console().readLine();
		System.out.println("Input taken from keyboard is - " + input);
	}

}
