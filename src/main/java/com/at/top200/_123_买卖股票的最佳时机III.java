package com.at.top200;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/


public class _123_买卖股票的最佳时机III {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        // 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
        int[][] dp = new int[n][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];

        for (int i = 1; i < n; i++) {

            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i][3] + prices[i]);
        }

        return dp[n - 1][4];
    }
}
