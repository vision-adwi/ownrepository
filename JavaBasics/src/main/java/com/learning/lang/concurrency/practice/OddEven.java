package com.learning.lang.concurrency.practice;

public class OddEven {
	public static void main(String[] s) {
		/*Repository resource = new Repository();
		Runnable odd = new OddGenerator(resource);
		Runnable even = new EvenGenerator(resource);*/
		NumberGenerator generator = new NumberGenerator();
		
		new Thread(generator::run).start();
		new Thread(() -> generator.run()).start(); //2 flavors of calling(through lambda)
		
/*
		Thread t1 = new Thread(generator);
		t1.setName("Even");
		Thread t2 = new Thread(generator);
		t2.setName("Odd");
		
		t1.start();
		t2.start();*/
	}

}

class NumberGenerator {
	private volatile int num;

	public void run() {
		while (num < 20) {
			synchronized (this) {
				System.out.print(num + " "); //Thread.currentThread().getName() + ":" + 
				num = num + 1;
				notifyAll();
				try {
					Thread.sleep(2 * 1000);
					wait();
				} catch (InterruptedException e) {
				}
			}
		}

	}
}

class OddGenerator implements Runnable {
	Repository num;

	OddGenerator(Repository repo) {
		num = repo;
	}

	public void run() {
		while (num.i < 100) {
			synchronized (num) {
				if ((num.i % 2) == 0) {
					try {
						num.wait();
					} catch (InterruptedException e) {
					}
				}

				System.out.print(Thread.currentThread().getName() + ":" + num.i + " ");
				num.i = num.i + 1;
				num.notifyAll();
			}
		}

	}
}

class EvenGenerator implements Runnable {
	Repository num;
	EvenGenerator(Repository i) {
		num = i;
	}
	
	public void run() {
		while (num.i < 100) {
			synchronized (num) {
				if((num.i % 2) != 0) {
					try {
						num.wait();
					} catch (InterruptedException e) {
					}
				}
				
				System.out.print(Thread.currentThread().getName() + ":" + num.i + " ");
				num.i = num.i + 1;
				num.notifyAll();
			}
		}
	}
}

class Repository {
	int i;
}
