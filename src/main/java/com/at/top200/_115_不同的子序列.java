package com.at.top200;

// https://leetcode.cn/problems/distinct-subsequences/description/

public class _115_不同的子序列 {

    public int numDistinct(String s, String t) {

        int n = s.length(), m = t.length();
        char[] sArr = (" " + s).toCharArray(), tArr = (" " + t).toCharArray();

        // dp(i,j) 代表考虑「s 中的下标为 0~i 字符」和「t 中下标为 0~j 字符」是否匹配
        int[][] dp = new int[n + 1][m + 1];

        // 原字符只有小写字符，当往两个字符插入空格之后，f[i][0] = 1 是一个显而易见的初始化条件
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // 不要
                dp[i][j] = dp[i - 1][j];
                // 要
                if (sArr[i] == tArr[j]) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[n][m];
    }
}
