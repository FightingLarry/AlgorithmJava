package com.larry.algorithm.sort;

public class ShellSort {

	/**
	 * ≤Â»Î≈≈–Ú£¨O(N2)
	 * 
	 * @param a
	 */
	public static <T extends Comparable<? super T>> void shellSort(T[] a) {
		int j = 0;
		for (int gap = a.length / 2; gap > 0; gap /= 2) {
			System.out.println("========1.gap=" + gap);
			for (int i = gap; i < a.length; i++) {
				System.out.println("===2.i=" + i);
				T tmp = a[i];
				for (j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap) {
					System.out.println("===3.a[" + j + "]=" + a[j] + ",a["
							+ (j - gap) + "]=" + a[j - gap]);
					a[j] = a[j - gap];
				}
				a[j] = tmp;

				privateA(a);
			}

		}
	}

	private static <T> void privateA(T[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Integer[] a = { 81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15 };
		Integer[] a = { 1, 9, 2, 10, 3, 11, 4, 12, 5, 13, 6, 14, 7, 15, 8, 16 };
		shellSort(a);

	}

}
