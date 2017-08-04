package com.larry.multithreading.producerOfconsumer.p1cnStack;

import com.larry.multithreading.producerOfconsumer.p1c1Stack.MyStack;
import com.larry.multithreading.producerOfconsumer.p1c1Stack.ThreadC;
import com.larry.multithreading.producerOfconsumer.p1c1Stack.ThreadP;

/**
 * һ������n�����ߣ�����ջ�������ܼ���
 *
 */
public class Run {
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		ThreadP pThread = new ThreadP(myStack);
		pThread.setName("������");
		pThread.start();

		final int N = 5;

		ThreadC[] cThread = new ThreadC[N];
		for (int i = 0; i < N; i++) {
			cThread[i] = new ThreadC(myStack);
			cThread[i].setName("������" + (i + 1));
			cThread[i].start();
		}

	}
}
