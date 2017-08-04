package com.larry.multithreading.producerOfconsumer.p1c1Value;

public class ThreadP extends Thread {

	private P p;

	public ThreadP(P p) {
		this.p = p;
	}

	@Override
	public void run() {

		while (true) {
			p.setValue();
		}

	}

}
