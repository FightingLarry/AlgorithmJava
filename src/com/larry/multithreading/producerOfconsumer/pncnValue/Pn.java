package com.larry.multithreading.producerOfconsumer.pncnValue;

import com.larry.multithreading.producerOfconsumer.ValueObject;

/**
 * ������
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
					System.out.println("������" + Thread.currentThread().getName()
							+ " Waiting�� +++++");
					lock.wait();
				}
				String value = System.currentTimeMillis() + "_"
						+ System.nanoTime();
				System.out.println("������" + Thread.currentThread().getName()
						+ " Runnable�ˣ�value=" + value);
				ValueObject.value = value;
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
