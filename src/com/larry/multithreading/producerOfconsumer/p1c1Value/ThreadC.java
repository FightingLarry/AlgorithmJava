package com.larry.multithreading.producerOfconsumer.p1c1Value;

public class ThreadC extends Thread {

	private C c;

	public ThreadC(C c) {
		this.c = c;
	}

	@Override
	public void run() {

		while (true) {
			c.getValue();
		}

	}

}
