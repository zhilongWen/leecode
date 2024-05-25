package com.at.top100;


// https://leetcode.cn/problems/divide-two-integers/

public class _029_两数相除 {

    public int divide(int dividend, int divisor) {

        int sign = ((dividend ^ divisor) >> 31 & 1) == 1 ? -1 : 1;

        long result = 0;
        long d1 = Math.abs((long) dividend), d2 = Math.abs((long) divisor);

        while (d1 >= d2) {

            long i = 1;
            long tmp = d2;
            while (d1 >= tmp) {
                d1 -= tmp;
                result += i;
                i = i << 1;
                tmp = tmp << 1;
            }
        }

        result *= sign;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) result;
    }
}
