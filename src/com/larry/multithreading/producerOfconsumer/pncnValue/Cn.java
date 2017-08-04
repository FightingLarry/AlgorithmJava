package com.larry.multithreading.producerOfconsumer.pncnValue;

import com.larry.multithreading.producerOfconsumer.ValueObject;

/**
 * ������
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
					System.out.println("������" + Thread.currentThread().getName()
							+ " Waiting�� ------");
					lock.wait();
				}
				System.out.println("������" + Thread.currentThread().getName()
						+ " Runnale�ˣ� value=" + ValueObject.value);
				ValueObject.value = "";
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
