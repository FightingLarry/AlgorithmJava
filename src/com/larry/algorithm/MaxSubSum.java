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
     * 分治算法，2的N次方个元素才有效。
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

    public static int maxSubSum4(int[] a) {
        int maxSum = 0, thisSum = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
                System.out.println("i=" + i + ",thisSum=" + thisSum);
            } else if (thisSum < 0) {
                thisSum = 0;
                System.out.println("i=" + i + "==>00");
            }
        }
        return maxSum;
    }

    /**
     * 一个for的99乘法表
     * 
     * @param n
     */
    public static void x99(int n) {
        for (int i = 1, j = 1; j <= n; j++) {
            System.out.print(j + "*" + i + "=" + i * j + " ");
            if (j < n && i == j) {
                j = 0;
                i++;
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * --i和i--的算法。C语言和Java的结果不一样
     */
    public static void testppIIpp() {
        int i = 0, j = 0;
        do {
            --i;
            j--;
            System.out.println("i=" + i);
            System.out.println("j=" + j);
            break;
        } while (j < 0);
        System.out.println("i=" + i);
        System.out.println("j=" + j);

        int c = 0, d = 0, e = 0, f = 0, g = 0;
        for (int a = 0, b = 0; a < 10; ++a, b++) {
            ++c;
            d++;
            System.out.println("a=" + a + ",b=" + b + ",c=" + c + ",d=" + d + " e=" + e + " (++e + ++e)=" + (++e + ++e)
                    + " e=" + e + " f=" + f + " (f++ + f++)=" + (f++ + f++) + " f=" + f + " (++g + ++g + ++g)="
                    + (++g + ++g + ++g));
        }

    }

    public static void main(String[] args) {

        int a[] = {-4, -3, 5, -1, -1, 2, -1, 2};

        System.out.println(maxSubSumON2(a));

        System.out.println(maxSubSumDivideAndConquer(a, 0, a.length - 1));

        System.out.println(maxSubSum4(a));

        x99(12);

        testppIIpp();



    }


}
