package com.at.top200;

// https://leetcode.cn/problems/palindrome-partitioning-ii/description/

import java.util.Arrays;

public class _132_分割回文串II {

    public int minCut(String s) {

        int n = s.length();
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {

                if (i == j) {
                    dp[i][j] = true;
                } else {
                    if (arr[i] == arr[j]) {

                        if (j - i + 1 == 2 || dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int r = 0; r < n; r++) {

            if (dp[0][r]) {
                f[r] = 0;
            } else {
                for (int l = 0; l < r; l++) {
                    if (dp[l + 1][r]) {
                        f[r] = Math.min(f[r], f[l] + 1);
                    }
                }
            }
        }

        return f[n - 1];
    }
}
