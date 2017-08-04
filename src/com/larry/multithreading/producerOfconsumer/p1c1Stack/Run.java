package com.larry.multithreading.producerOfconsumer.p1c1Stack;

/**
 * 一生成者一消费者：操作栈
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
