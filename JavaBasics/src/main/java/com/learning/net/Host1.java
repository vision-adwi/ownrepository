package com.learning.net;

public class Host1 {

	public static void main(String[] args) throws InterruptedException {
		ServerListener listener = new ServerListener(5000);
		Client client = new Client(4000);
		
		Thread t1 = new Thread(listener);
		Thread t2 = new Thread(client);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

	}

}
