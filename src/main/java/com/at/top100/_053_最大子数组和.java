package com.at.top100;

// https://leetcode.cn/problems/maximum-subarray/

public class _053_最大子数组和 {

    public int maxSubArray(int[] nums) {

        int pre = 0, ans = nums[0];

        for (int num : nums) {
            pre = Math.max(num, num + pre);
            ans = Math.max(ans, pre);
        }

        return ans;
    }
}
