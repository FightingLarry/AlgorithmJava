package com.larry.algorithm;

import java.util.Comparator;

public class TestComparator {

	public static <T> T findMax(T[] arr, Comparator<? super T> cmp) {

		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			if (cmp.compare(arr[i], arr[max]) > 0) {
				max = i;
			}
		}
		return arr[max];

	}

	public class CaseInsensitiveCompare implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			// return o1.compareTo(o2);
			return o1.compareToIgnoreCase(o2);
		}

	}

	public static void main(String[] args) {

		String[] arr = { "Zebra", "Alligator", "crocodile" };
		TestComparator test = new TestComparator();
		System.out.println(findMax(arr, test.new CaseInsensitiveCompare()));
	}

}
