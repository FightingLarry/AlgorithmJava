package com.larry.multithreading.producerOfconsumer.p1c1Stack;

public class ThreadP extends Thread {

	private MyStack p;

	public ThreadP(MyStack p) {
		this.p = p;
	}

	@Override
	public void run() {

		while (true) {
			p.push();
		}

	}

}
