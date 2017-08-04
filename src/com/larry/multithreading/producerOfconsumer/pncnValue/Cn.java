package com.larry.multithreading.producerOfconsumer.pncnValue;

import com.larry.multithreading.producerOfconsumer.ValueObject;

/**
 * 消费者
 *
 */
public class Cn {
	private String lock;

	public Cn(String lock) {
		super();
		this.lock = lock;
	}

	public void getValue() {
		try {
			synchronized (lock) {
				if (ValueObject.value.equals("")) {
					System.out.println("消费者" + Thread.currentThread().getName()
							+ " Waiting了 ------");
					lock.wait();
				}
				System.out.println("消费者" + Thread.currentThread().getName()
						+ " Runnale了， value=" + ValueObject.value);
				ValueObject.value = "";
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
