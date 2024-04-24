package com.at.algorithmzuo;


// https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/

public class 动态规划_012_区间dp_1312_让字符串成为回文串的最少插入次数 {


    // 暴力尝试
    public int minInsertions(String s) {

        char[] arr = s.toCharArray();
        int len = arr.length;

        return f1(arr, 0, len - 1);

    }


    public int f1(char[] arr, int l, int r) {

        // 一个字符
        if (l == r) {
            return 0;
        }

        // 两个字符，至少加一个就可以成为回文
        if (l + 1 == r) {
            return arr[l] == arr[r] ? 0 : 1;
        }

        // > 2

        // arr[l] == arr[r]
        if (arr[l] == arr[r]) {
            return f1(arr, l + 1, r - 1);
        }

        // cbab
        // 右边加一个成为回文
        int rSize = f1(arr, l + 1, r);

        // babc
        // 左边加一个成为回文
        int lSize = f1(arr, l, r - 1);

        return Math.min(lSize, rSize) + 1;

    }

    // 记忆化搜索
    public int minInsertions2(String str) {

        char[] arr = str.toCharArray();
        int n = arr.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            // l <= r => j = i
            for (int j = i; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return f2(arr, 0, n - 1, dp);

    }

    public int f2(char[] arr, int l, int r, int[][] dp) {

        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        int ans;
        if (l == r) {
            ans = 0;
        } else if (l + 1 == r) {
            ans = arr[l] == arr[r] ? 0 : 1;
        } else {
            if (arr[l] == arr[r]) {
                ans = f2(arr, l + 1, r - 1, dp);
            } else {
                ans = Math.min(f2(arr, l + 1, r, dp), f2(arr, l, r - 1, dp)) + 1;
            }
        }

        dp[l][r] = ans;

        return ans;

    }

    // 严格位置依赖的动态规划
    public int minInsertions3(String str) {

        char[] arr = str.toCharArray();
        int n = arr.length;

        int[][] dp = new int[n][n];
        // 初始化全为 0

        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = arr[i] == arr[i + 1] ? 0 : 1;
        }

        for (int l = n - 3; l >= 0; l--) {
            for (int r = l + 2; r < n; r++) {
                if (arr[l] == arr[r]) {
                    dp[l][r] = dp[l + 1][r - 1]; // 左下对角线格子
                } else {
                    dp[l][r] = Math.min(dp[l + 1][r], dp[l][r - 1]) + 1;
                }
            }
        }

        return dp[0][n - 1];

    }


}
