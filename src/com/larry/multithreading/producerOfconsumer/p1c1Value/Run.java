package com.larry.multithreading.producerOfconsumer.p1c1Value;

/**
 * 一生成者一消费者：操作值
 *
 */
public class Run {

	public static void main(String[] args) {
		String lock = new String("");
		P p = new P(lock);
		C c = new C(lock);
		ThreadP pThread = new ThreadP(p);
		ThreadC cTread = new ThreadC(c);
		pThread.start();
		cTread.start();
	}

}
