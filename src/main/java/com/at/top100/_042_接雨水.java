package com.at.top100;

// https://leetcode.cn/problems/trapping-rain-water/

public class _042_接雨水 {

    public int trap(int[] height) {

        int len = height.length;
        if (len <= 2) {
            return 0;
        }

        int ans = 0, l = 1, r = len - 2, lMax = height[0], rMax = height[len - 1];

        while (l <= r) {

            if (lMax <= rMax) {
                ans += Math.max(0, lMax - height[l]);
                lMax = Math.max(lMax, height[l++]);
            } else {
                ans += Math.max(0, rMax - height[r]);
                rMax = Math.max(rMax, height[r--]);
            }
        }

        return ans;
    }
}
