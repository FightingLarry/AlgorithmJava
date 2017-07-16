package com.larry.algorithm;

public class OuJiLiDeAlgorithm {
    /**
     * ŷ�����㷨
     * 
     * @param m
     * @param n
     * @return
     */
    public static long gcd(long m, long n) {

        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    /**
     * ������֤��<br>
     * �����ż����x��N��=x��N/2��*x��N/2��<br>
     * �����������x��N��=x��(N-1)/2��*x��(N-1)/2��*x
     */
    public static long pow(long x, int n) {

        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if ((n & 1) == 0) {
            // ż��
            return pow(x * x, n / 2);
        } else {
            // ����
            return pow(x * x, n / 2) * x;
        }
    }


    public static void main(String[] args) {

        long a = 9;
        long b = 7;
        System.out.println(a + "," + b + ":" + gcd(a, b));

        a = 99;
        b = 60;
        System.out.println(a + "," + b + ":" + gcd(a, b));

        long x = 2;
        int n = 8;
        System.out.println(x + "��" + n + "�η�=" + pow(x, n));

        x = 3;
        n = 10;
        System.out.println(x + "��" + n + "�η�=" + pow(x, n));

        x = -2;
        n = 8;
        System.out.println(x + "��" + n + "�η�=" + pow(x, n));
        
        x = -2;
        n = 9;
        System.out.println(x + "��" + n + "�η�=" + pow(x, n));
        
        x = -1;
        n = 9;
        System.out.println(x + "��" + n + "�η�=" + pow(x, n));
        

        x = (long) 2.5;
        n = 9;
        System.out.println(x + "��" + n + "�η�=" + pow(x, n));
    }
}
