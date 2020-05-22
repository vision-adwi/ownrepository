package com.learning.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelExercise {

	public static void main(String[] args) throws IOException {
		RandomAccessFile file = new RandomAccessFile("channel.txt", "rw");

		FileChannel channel = file.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(48);
		
		//writeToChannel(channel, buf);
		//buf.flip();
		readFromChannel(channel, buf);

		file.close();
	}
	
	private static void writeToChannel(FileChannel theChannel, ByteBuffer buffer) throws IOException {
		String message = "This";
		//about writing to and reading from the NIO channels.";
		
		for (byte b : message.getBytes()) {
			if(buffer.remaining() <= 0) {
				theChannel.write(buffer);
				buffer.clear();
			}
			
			buffer.put(b);
		}
		theChannel.write(buffer);
		buffer.clear();
	}
	
	private static void readFromChannel(FileChannel theChannel, ByteBuffer buffer)
			throws IOException 
	{
		int b = theChannel.read(buffer);
		
		while (b != -1) {
			//buffer.flip();
			System.out.println(" Capacity: " + buffer.capacity() + " Limit: " + buffer.limit() + " Position: " + buffer.position());
			while (buffer.hasRemaining()) {
				System.out.print((char) buffer.get());
			}
			System.out.println("");
			System.out.println(" Capacity: " + buffer.capacity() + " Limit: " + buffer.limit() + " Position: " + buffer.position());
			buffer.clear(); // make buffer ready for writing
			System.out.println(" Capacity: " + buffer.capacity() + " Limit: " + buffer.limit() + " Position: " + buffer.position());
			b = theChannel.read(buffer);
			System.out.println(" Capacity: " + buffer.capacity() + " Limit: " + buffer.limit() + " Position: " + buffer.position());
		}
	}

}
