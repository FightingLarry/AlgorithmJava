package com.larry.tencent;

public class TencentTest {

	public static void main(String[] args) {
		// 1
		int i = 1;
		System.out.println(i++ + 3 << 2);

		// 2
		int j = 1;
		System.out.println(j++ + ++j);

		// 3
		System.out.println(tencent("Tencent"));
		String t = "T".substring(1);
		System.out.println(t);

		// 4
		insertNumber(100);
	}

	public static String tencent(String s) {
		System.out.println("¹ı³Ì£º" + s);
		return s.length() > 0 ? tencent(s.substring(1)) + s.charAt(0) : "";
	}

	public static void insertNumber(int N) {
		int array[] = new int[N];
		int index = 0;
		while (true) {
			int i = (int) (Math.random() * N);
			if (array[i] == 0) {
				array[i] = i + 1;
				index++;
			}
			System.out.println("i=" + i);
			if (index == N) {
				break;
			}
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}

	}
}
