package com.at.algorithmzuo;

import java.io.*;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/maximum-value-of-k-coins-from-piles/description/

public class 动态规划_007_分组背包_2218_从栈中取出K个硬币的最大面值和 {

    public int maxValueOfCoins(List<List<Integer>> piles, int m) {

        // 组数
        int n = piles.size();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            // 第 i 组中的所有数据
            List<Integer> team = piles.get(i - 1);

            int t = Math.min(team.size(), m);

            // 处理前缀和
            int[] preSum = new int[t + 1];
            for (int j = 0, sum = 0; j < t; j++) {
                sum += team.get(j);
                preSum[j + 1] = sum;
            }

            for (int j = 0; j <= m; j++) {
                // 不要
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k <= Math.min(t, j); k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k] + preSum[k]);
                }
            }
        }

        return dp[n][m];

    }

    public int maxValueOfCoins1(List<List<Integer>> piles, int m) {

        int[] dp = new int[m + 1];

        for (List<Integer> stack : piles) {

            int t = Math.min(stack.size(), m);
            int[] preSum = new int[t + 1];
            for (int i = 0, sum = 0; i < t; i++) {
                sum += stack.get(i);
                preSum[i + 1] = sum;
            }

            for (int w = m; w > 0; w--) {
                for (int i = 1; i <= Math.min(t, w); i++) {
                    dp[w] = Math.max(dp[w], preSum[i] + dp[w - i]);
                }
            }

        }

        return dp[m];

    }

}
