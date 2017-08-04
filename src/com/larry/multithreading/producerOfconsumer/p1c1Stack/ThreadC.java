package com.larry.multithreading.producerOfconsumer.p1c1Stack;

public class ThreadC extends Thread {

	private MyStack c;

	public ThreadC(MyStack c) {
		this.c = c;
	}

	@Override
	public void run() {

		while (true) {
			c.pop();
		}

	}

}
