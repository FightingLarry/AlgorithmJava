package com.larry.multithreading.producerOfconsumer.p1c1Stack;

import java.util.LinkedList;
import java.util.List;

public class MyStack {

	private final static int SIZE = 4;

	private List<String> list = new LinkedList<>();

	/**
	 * 生产者
	 */
	public synchronized void push() {
		try {
			// 因为list改变时得不到及时的响应，需要改成while,
			// 否则java.lang.IndexOutOfBoundsException:Index: 0, Size:
			// 0pop操作中的：消费者4 Waiting

			// if (list.size() == 1) {
			// this.wait();
			// }
			while (list.size() >= SIZE) {
				System.out.println("+++ push操作中的："
						+ Thread.currentThread().getName() + " Waiting");
				this.wait();
			}
			String value = "value" + Math.random();
			list.add(value);
			// 出现假死，需要改成notifyAll
			// this.notify();
			this.notifyAll();
			System.out.println("push=" + list.size() + "  " + value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 消费者
	 * 
	 * @return
	 */
	public synchronized String pop() {
		String value = "";
		try {
			// 因为list改变时得不到及时的响应，需要改成while,
			// 否则java.lang.IndexOutOfBoundsException:Index: 0, Size:
			// 0pop操作中的：消费者4 Waiting
			// if (list.size() == 0) {
			// System.out.println("pop操作中的："
			// + Thread.currentThread().getName() + " Waiting");
			// this.wait();
			// }
			while (list.size() == 0) {
				System.out.println("--- pop操作中的："
						+ Thread.currentThread().getName() + " Waiting");
				this.wait();
			}
			value = list.remove(0);
			// 出现假死，需要改成notifyAll
			// this.notify();
			this.notifyAll();
			System.out.println("pop=" + list.size() + "  " + value);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
