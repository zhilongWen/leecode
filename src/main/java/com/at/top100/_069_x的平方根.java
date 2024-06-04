package com.at.top100;

// https://leetcode.cn/problems/sqrtx/description/

public class _069_x的平方根 {

    public int mySqrt(int x) {

        int l = 0, r = x, ans = -1;

        while (l <= r) {

            int mid = l + ((r - l) >> 1);
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}
