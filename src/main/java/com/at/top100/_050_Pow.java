package com.at.top100;

// https://leetcode.cn/problems/powx-n/

public class _050_Pow {

    public double myPow(double x, int n) {

        if (x == 0.0D) {
            return x;
        }

        long b = n;
        double ans = 1.0;

        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                ans *= x;
            }
            x *= x;
            b >>= 1;
        }

        return ans;
    }
}
