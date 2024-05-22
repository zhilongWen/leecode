package com.at.top100;

// https://leetcode.cn/problems/container-with-most-water/description/

public class _011_盛最多水的容器 {

    public int maxArea(int[] height) {

        int ans = 0, l = 0, r = height.length - 1;

        while (l < r) {

            ans = Math.max(ans, (r - l) * Math.min(height[l], height[r]));

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }
}
