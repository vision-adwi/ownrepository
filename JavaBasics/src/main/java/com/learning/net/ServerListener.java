package com.learning.net;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener implements Runnable {
	int port;
	ServerSocket server;
	Socket client;

	public ServerListener(int port) {
		this.port = port;
	}

	public void run() {
		try {
			server = new ServerSocket(port);
			client = server.accept();

			DataInputStream input = new DataInputStream(
					new BufferedInputStream(client.getInputStream()));

			String line = "";
			while (line != "Over") {
				line = input.readUTF();
				System.out.println('\n'+line);
			}

			input.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
