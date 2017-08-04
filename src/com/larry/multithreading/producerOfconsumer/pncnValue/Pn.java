package com.larry.multithreading.producerOfconsumer.pncnValue;

import com.larry.multithreading.producerOfconsumer.ValueObject;

/**
 * 生成者
 *
 */
public class Pn {

	private String lock;

	public Pn(String lock) {
		super();
		this.lock = lock;
	}

	public void setValue() {
		try {
			synchronized (lock) {
				if (!ValueObject.value.equals("")) {
					System.out.println("生产者" + Thread.currentThread().getName()
							+ " Waiting了 +++++");
					lock.wait();
				}
				String value = System.currentTimeMillis() + "_"
						+ System.nanoTime();
				System.out.println("生产者" + Thread.currentThread().getName()
						+ " Runnable了，value=" + value);
				ValueObject.value = value;
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
