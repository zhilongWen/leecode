package com.at.top100;

// https://leetcode.cn/problems/climbing-stairs/description/

public class _070_爬楼梯 {

    public int climbStairs(int n) {

        if (n == 1 || n == 2) {
            return n;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }

    public int climbStairs1(int n) {

        if (n == 1 || n == 2) {
            return n;
        }
        int a = 1, b = 2, ans = 0;
        for (int i = 2; i < n; i++) {
            ans = a + b;
            a = b;
            b = ans;
        }

        return ans;
    }

}
