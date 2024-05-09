package com.at.algorithmzuo;


// 接雨水
// 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
// 测试链接 : https://leetcode.cn/problems/trapping-rain-water/

public class 双指针_003_42_接雨水 {

    // 辅助数组的解法（不是最优解）
    // 时间复杂度O(n)，额外空间复杂度O(n)
    public int trap1(int[] height) {

        int n = height.length;


        int[] lmax = new int[n];
        lmax[0] = height[0];
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }

        int[] rmax = new int[n];
        rmax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], height[i]);
        }

        int ans = 0;

        // 0  .....  n
        // 0 位置 和 n 位置一定不能存水
        for (int i = 1; i < n - 1; i++) {
            ans += Math.max(0, Math.min(lmax[i - 1], rmax[i + 1]) - height[i]);
        }

        return ans;
    }

    // 双指针的解法（最优解）
    // 时间复杂度O(n)，额外空间复杂度O(1)
    public int trap(int[] height) {

        int n = height.length;

        int ans = 0, l = 1, r = n - 2, lmax = height[0], rmax = height[n - 1];

        while (l <= r) {

            if (lmax <= rmax) {
                // 结算左边
                ans += Math.max(0,lmax - height[l]);
                lmax = Math.max(lmax,height[l++]);
            } else {
                // 结算右边
                ans += Math.max(0,rmax - height[r]);
                rmax = Math.max(rmax,height[r--]);
            }

        }

        return ans;
    }
}
