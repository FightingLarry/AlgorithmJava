package com.larry.multithreading.producerOfconsumer.pncnStack;

import com.larry.multithreading.producerOfconsumer.p1c1Stack.MyStack;
import com.larry.multithreading.producerOfconsumer.p1c1Stack.ThreadC;
import com.larry.multithreading.producerOfconsumer.p1c1Stack.ThreadP;

/**
 * n������n�����ߣ�����ջ
 *
 */
public class Run {
	public static void main(String[] args) {

		MyStack myStack = new MyStack();

		final int N = 5;

		ThreadP[] pThread = new ThreadP[N];
		ThreadC[] cThread = new ThreadC[N];
		for (int i = 0; i < N; i++) {
			pThread[i] = new ThreadP(myStack);
			pThread[i].setName("������" + (i + 1));
			pThread[i].start();

			cThread[i] = new ThreadC(myStack);
			cThread[i].setName("������" + (i + 1));
			cThread[i].start();
		}

	}
}