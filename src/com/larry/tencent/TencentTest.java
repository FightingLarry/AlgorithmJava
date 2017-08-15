package com.larry.tencent;

public class TencentTest {

	public static void main(String[] args) {
		int i = 1;
		System.out.println(i++ + 3 << 2);

		int j = 1;
		System.out.println(j++ + ++j);

		System.out.println(tencent("Tencent"));
		 String t = "T".substring(1);
		 System.out.println(t);

	}

	public static String tencent(String s) {
		return s.length() > 0 ? tencent(s.substring(1)) + s.charAt(0) : "";
	}

}
