package com.learning.io.streams.output;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class OutputStreamDemo {

	public static void main(String[] args) throws IOException {
		//fileOutputStreamTest();
		//byteArrayOutputStreamTest();
		bufferedOutputStreamTest();

	}

	private static void fileOutputStreamTest() throws IOException {
		String content = "This is the write up that is going to be written !!!";

		OutputStream out = new FileOutputStream("stream.txt");
		for (byte b : content.getBytes()) {
			out.write(b);
		}
		out.close();
	}
	
	private static void byteArrayOutputStreamTest() throws IOException {
		OutputStream out = new ByteArrayOutputStream();
		InputStream in = new FileInputStream("stream.txt");

		while (in.available() > 0) {
			out.write(in.read());
		}
		
		System.out.println("Stream output is - " + out);
		in.close();
	}
	
	private static void dataOutputStreamTest() throws IOException {
		DataOutput dataOut = new DataOutputStream(new FileOutputStream("stream.txt"));
		
		dataOut.writeDouble(2.4);
		dataOut.writeShort(4);
	}
	
	private static void bufferedOutputStreamTest() throws IOException {
		String content = "This is the write up that is going to be written !!!";
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("stream.txt"));
		
		for (byte b : content.getBytes()) {
			out.write(b);
		}
		out.flush();
		out.close();
	}
	
	private static void printStreamTest() throws FileNotFoundException {
		PrintStream print = new PrintStream(new FileOutputStream("stream.txt"));
		
		print.println("This is PrintStream");
		print.print("a new line is addded");
	}

}
