package com.larry.multithreading.producerOfconsumer.pncnValue;

/**
 * 多生成者多消费者：操作值——假死<br/>
 * 会出现假死状态，通过notifyAll来解决
 */
public class Run {

	public static void main(String[] args) {
		String lock = new String("");
		Pn p = new Pn(lock);
		Cn c = new Cn(lock);

		final int N = 2;

		ThreadPn[] pThread = new ThreadPn[N];
		ThreadCn[] cThread = new ThreadCn[N];
		for (int i = 0; i < N; i++) {
			pThread[i] = new ThreadPn(p);
			pThread[i].setName("生成者" + (i + 1));
			cThread[i] = new ThreadCn(c);
			cThread[i].setName("消费者" + (i + 1));

			pThread[i].start();
			cThread[i].start();
		}

		try {
			Thread.sleep(5000);
			Thread[] threadArray = new Thread[Thread.currentThread()
					.getThreadGroup().activeCount()];
			Thread.currentThread().getThreadGroup().enumerate(threadArray);
			for (int i = 0; i < threadArray.length; i++) {
				System.out.println(threadArray[i].getName() + " "
						+ threadArray[i].getState());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
