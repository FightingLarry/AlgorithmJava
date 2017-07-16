package com.larry.algorithm;

import java.util.Arrays;
import java.util.Collections;

public class BinaryAlgorithm {


    public static <T extends Comparable<? super T>> int binarySearch(T a[], T t) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid].compareTo(t) < 0) {
                low = mid + 1;
                System.out.println("low=" + low);
            } else if (a[mid].compareTo(t) > 0) {
                high = mid - 1;
                System.out.println("high=" + high);
            } else {
                return mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int N = 100;
        String a[] = new String[N];
        for (int i = 0; i < N; i++) {
            a[i] = String.valueOf(i);
        }
        Collections.sort(Arrays.asList(a));
        System.out.println("String==================");
        System.out.println(binarySearch(a, a[10]));


        Integer b[] = new Integer[N];
        for (int i = 0; i < N; i++) {
            b[i] = i;
        }
        System.out.println("Integer==================");
        System.out.println(binarySearch(b, b[10]));


    }

}
