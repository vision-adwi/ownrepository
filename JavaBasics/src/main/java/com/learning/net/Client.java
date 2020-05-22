package com.learning.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client implements Runnable {
	private int port;
	private Socket socket;
	private DataInputStream input;
	private DataOutputStream output;

	public Client(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		waitForSomeTime();
		System.out.println("Ready to chat");
		try {
			socket = new Socket("127.0.0.1", port);
			input = new DataInputStream(System.in);
			output = new DataOutputStream(socket.getOutputStream());
			
			String line = "";
			while(line != "Over") {
				line = input.readLine();
				output.writeUTF(line);
			}

			output.close();
			input.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void waitForSomeTime() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
