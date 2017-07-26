package com.larry.algorithm.sort;

public class HeapSort {

	private static int leftChild(int i) {
		return 2 * i + 1;
	}

	private static <T extends Comparable<? super T>> void percDown(T[] a,
			int i, int n) {
		int child = 0;
		T tmp;
		for (tmp = a[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0) {
				child++;
			}
			if (tmp.compareTo(a[child]) < 0) {
				a[i] = a[child];
			} else {
				break;
			}
		}
		a[i] = tmp;
	}

	public static <T extends Comparable<? super T>> void heapsort(T[] a) {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
