package com.larry.multithreading.producerOfconsumer.pnc1Stack;

import com.larry.multithreading.producerOfconsumer.p1c1Stack.MyStack;
import com.larry.multithreading.producerOfconsumer.p1c1Stack.ThreadC;
import com.larry.multithreading.producerOfconsumer.p1c1Stack.ThreadP;

/**
 * n生成者1消费者：操作栈
 *
 */
public class Run {
	public static void main(String[] args) {
		MyStack myStack = new MyStack();

		final int N = 5;

		ThreadP[] pThread = new ThreadP[N];
		for (int i = 0; i < N; i++) {
			pThread[i] = new ThreadP(myStack);
			pThread[i].setName("生产者" + (i + 1));
			pThread[i].start();
		}

		ThreadC cThread = new ThreadC(myStack);
		cThread.setName("消费者");
		cThread.start();

	}
}