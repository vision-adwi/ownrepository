package com.learning.io.streams.input;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {

	public static void main(String[] args) {
		try {
			fileInputStreamTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void byteArrayInputStreamTest() throws IOException {
		String content = "This is the content for ByteArrayInputStream";
		byte[] source = content.getBytes();

		InputStream in = new ByteArrayInputStream(source);
		int b;
		while ((b = in.read()) != -1) {
			System.out.print((char)b);

			if (in.available() == 11) {
				in.mark(17); // Parameter passed is immaterial
			}
		}
		System.out.println();
		in.reset();
		System.out.println("After reset to last mark position");
		while ((b = in.read()) != -1) {
			System.out.print((char)b);
		}
	}

	private static void fileInputStreamTest() throws IOException {
		InputStream in = new FileInputStream("stream.txt");

		/*while (in.available() > 0) {
			System.out.print((char)in.read());

		}*/
		int b;
		while ((b = in.read()) != -1) {
			System.out.print((char)b);
		}
		in.close();
	}
	
	private static void dataInputStreamTest() throws IOException {
		@SuppressWarnings("resource")
		DataInput dataIn = new DataInputStream(new FileInputStream("stream.txt"));
		System.out.println("Data Input: readDouble() - " + dataIn.readDouble() ) ;
		System.out.println("Data Input: readShort() - " + dataIn.readShort() ) ;
		//System.out.println("Data Input:readLine() - " + filterIn.readLine() );
	}
	
	private static void bufferedInputStreamTest() throws IOException {
		BufferedInputStream bufferedStream = new BufferedInputStream(
				new FileInputStream("stream.txt"));

		int b;
		while ((b = bufferedStream.read()) != -1) {
			System.out.print((char) b);
		}
	}
	
	private static void filterInputStreamTest() throws IOException {
		DataInput dataIn = new DataInputStream(new BufferedInputStream(
				new FileInputStream("stream.txt")));
		
		System.out.println("Data Input: readDouble() - " + dataIn.readDouble() ) ;
		System.out.println("Data Input: readShort() - " + dataIn.readShort() ) ;
	}
	
}
