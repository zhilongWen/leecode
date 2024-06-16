package com.at.algorithmzuo;

// https://leetcode.cn/problems/maximum-width-ramp/

public class 单调栈_006_962_最大宽度坡 {

    public int maxWidthRamp(int[] nums) {

        int n = nums.length;
        int[] stack = new int[n];
        int ans = 0, r = 1;

        for (int i = 1; i < n; i++) {

            if (nums[i] < nums[stack[r - 1]]) {
                stack[r++] = i;
            }
        }

        for (int i = n - 1; i >= 0; i--) {

            while (r > 0 && nums[stack[r - 1]] <= nums[i]) {
                ans = Math.max(ans, i - stack[--r]);
            }
        }

        return ans;
    }
}
