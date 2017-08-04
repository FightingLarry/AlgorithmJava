package com.larry.multithreading.producerOfconsumer.p1c1Stack;

import java.util.LinkedList;
import java.util.List;

public class MyStack {

	private final static int SIZE = 4;

	private List<String> list = new LinkedList<>();

	/**
	 * ������
	 */
	public synchronized void push() {
		try {
			// ��Ϊlist�ı�ʱ�ò�����ʱ����Ӧ����Ҫ�ĳ�while,
			// ����java.lang.IndexOutOfBoundsException:Index: 0, Size:
			// 0pop�����еģ�������4 Waiting

			// if (list.size() == 1) {
			// this.wait();
			// }
			while (list.size() >= SIZE) {
				System.out.println("+++ push�����еģ�"
						+ Thread.currentThread().getName() + " Waiting");
				this.wait();
			}
			String value = "value" + Math.random();
			list.add(value);
			// ���ּ�������Ҫ�ĳ�notifyAll
			// this.notify();
			this.notifyAll();
			System.out.println("push=" + list.size() + "  " + value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ������
	 * 
	 * @return
	 */
	public synchronized String pop() {
		String value = "";
		try {
			// ��Ϊlist�ı�ʱ�ò�����ʱ����Ӧ����Ҫ�ĳ�while,
			// ����java.lang.IndexOutOfBoundsException:Index: 0, Size:
			// 0pop�����еģ�������4 Waiting
			// if (list.size() == 0) {
			// System.out.println("pop�����еģ�"
			// + Thread.currentThread().getName() + " Waiting");
			// this.wait();
			// }
			while (list.size() == 0) {
				System.out.println("--- pop�����еģ�"
						+ Thread.currentThread().getName() + " Waiting");
				this.wait();
			}
			value = list.remove(0);
			// ���ּ�������Ҫ�ĳ�notifyAll
			// this.notify();
			this.notifyAll();
			System.out.println("pop=" + list.size() + "  " + value);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
