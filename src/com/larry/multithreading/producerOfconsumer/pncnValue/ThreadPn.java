package com.larry.multithreading.producerOfconsumer.pncnValue;

public class ThreadPn extends Thread {

	private Pn p;

	public ThreadPn(Pn p) {
		this.p = p;
	}

	@Override
	public void run() {

		while (true) {
			p.setValue();
		}

	}

}
