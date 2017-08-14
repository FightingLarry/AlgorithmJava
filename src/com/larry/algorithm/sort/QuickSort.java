package com.larry.algorithm.sort;

public class QuickSort {

	public static void main(String[] args) {
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
				99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };
		if (a.length > 0) { // �鿴�����Ƿ�Ϊ��
			quickSort(a, 0, a.length - 1);
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println();
	}

	public static void quickSort(int[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high); // ��list �������һ��Ϊ��
			System.out.println(middle+":middle");
			quickSort(list, low, middle - 1); // �Ե��ֱ���еݹ�����
			quickSort(list, middle + 1, high); // �Ը��ֱ���еݹ�����
		}
	}

	public static int getMiddle(int[] list, int low, int high) {
		int tmp = list[low]; // ����ĵ�һ����Ϊ����
		while (low < high) {
			while (low < high && list[high] >= tmp) {
				System.out.println(high + "--");
				high--;
			}
			list[low] = list[high]; // ������С�ļ�¼�Ƶ��Ͷ�
			while (low < high && list[low] <= tmp) {
				System.out.println(low + "++");
				low++;
			}
			list[high] = list[low]; // �������ļ�¼�Ƶ��߶�
		}
		list[low] = tmp; // �����¼��β
		return low; // ���������λ��
	}

}
