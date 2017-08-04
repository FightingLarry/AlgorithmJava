package com.larry.multithreading.producerOfconsumer.p1c1Value;

import com.larry.multithreading.producerOfconsumer.ValueObject;

/**
 * ������
 *
 */
public class C {
	private String lock;

	public C(String lock) {
		super();
		this.lock = lock;
	}

	public void getValue() {
		try {
			synchronized (lock) {
				if (ValueObject.value.equals("")) {
					lock.wait();
				}
				System.out.println("get��ֵ��" + ValueObject.value);
				ValueObject.value = "";
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
