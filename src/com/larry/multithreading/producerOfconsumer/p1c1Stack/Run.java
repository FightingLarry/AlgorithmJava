package com.larry.multithreading.producerOfconsumer.p1c1Stack;

/**
 * һ������һ�����ߣ�����ջ
 *
 */
public class Run {

	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		ThreadP pThread = new ThreadP(myStack);
		ThreadC cTread = new ThreadC(myStack);
		pThread.start();
		cTread.start();
	}

}
