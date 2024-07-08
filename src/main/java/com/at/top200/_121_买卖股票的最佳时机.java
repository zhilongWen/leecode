package com.at.top200;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/


public class _121_买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {

        int cost = Integer.MAX_VALUE, ans = 0;

        for (int price : prices) {

            cost = Math.min(cost, price);
            ans = Math.max(ans, price - cost);
        }

        return ans;
    }
}
