package com.larry.algorithm;

/**
 * 最大子序列和的问题
 * 
 * @author Larry
 *
 */
public class MaxSubSum {

	/**
	 * O(N2)，最大复杂度2次的算法
	 * 
	 * @param a
	 * @return
	 */
	public static int maxSubSumON2(int[] a) {
		int maxSum = 0;
		for (int i = 0; i < a.length; i++) {
			int thisSum = 0;
			for (int j = i; j < a.length; j++) {
				thisSum += a[j];
				if (thisSum > maxSum) {
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}

	/**
	 * 分治算法，
	 * 
	 * @param a
	 * @return
	 */
	public static int maxSubSumDivideAndConquer(int[] a, int left, int right) {
		if (left == right) {
			// 只有一个元素
			return a[left] > 0 ? a[left] : 0;
		}
		int center = (left + right) / 2;
		int maxLeftSum = maxSubSumDivideAndConquer(a, left, center);
		int maxRightSum = maxSubSumDivideAndConquer(a, center + 1, right);

		int maxLeftBorderSum = 0, leftBorderSum = 0;
		for (int i = center; i >= left; i--) {
			leftBorderSum += a[i];
			if (leftBorderSum > maxLeftBorderSum) {
				maxLeftBorderSum = leftBorderSum;
			}
		}

		int maxRightBorderSum = 0, rightBorderSum = 0;
		for (int i = center + 1; i <= right; i++) {
			leftBorderSum += a[i];
			if (rightBorderSum > maxRightBorderSum) {
				maxRightBorderSum = rightBorderSum;
			}
		}
		int maxLR = maxLeftBorderSum + maxRightBorderSum;

		int maxLRSum = maxLeftSum > maxRightSum ? maxLeftSum : maxRightSum;
		return maxLRSum > maxLR ? maxLRSum : maxLR;
	}

	public static void main(String[] args) {

		int a[] = { -4, -3, 5, -2, -1, 2, 6, -2, 4, -1, 2 };

		System.out.println(maxSubSumON2(a));

		System.out.println(maxSubSumDivideAndConquer(a, 0, a.length - 1));

	}

}
