package com.learning.net;

public class Host2 {

	public static void main(String[] args) throws InterruptedException {
		ServerListener listener = new ServerListener(4000);
		Client client = new Client(5000);
		
		Thread t1 = new Thread(listener);
		Thread t2 = new Thread(client);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

	}

}
