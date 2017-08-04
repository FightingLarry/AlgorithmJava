package com.larry.multithreading.producerOfconsumer.pncnValue;

public class ThreadCn extends Thread {

	private Cn c;

	public ThreadCn(Cn c) {
		this.c = c;
	}

	@Override
	public void run() {

		while (true) {
			c.getValue();
		}

	}

}
