package com.larry.algorithm.sort;

public class InsertionSort {

	/**
	 * ≤Â»Î≈≈–Ú£¨O(N2)
	 * 
	 * @param a
	 */
	public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
		int j = 0;
		for (int p = 1; p < a.length; p++) {
			T tmp = a[p];
			for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--) {
				a[j] = a[j - 1];
			}
			a[j] = tmp;

			privateA(a);
		}
	}

	private static <T> void privateA(T[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Integer[] a = { 34, 8, 64, 51, 32, 21 };
		insertionSort(a);

	}

}
