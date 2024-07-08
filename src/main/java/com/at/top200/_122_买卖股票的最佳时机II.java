package com.at.top200;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/


public class _122_买卖股票的最佳时机II {

    public int maxProfit(int[] prices) {

        int ans = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                ans += (prices[i] - prices[i - 1]);
            }
        }

        return ans;
    }
}
