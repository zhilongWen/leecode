package com.at.top100;

// https://leetcode.cn/problems/jump-game/

public class _055_跳跃游戏 {

    public boolean canJump(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {

            if (dp[i - 1] == 0) {
                return false;
            }
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
        }

        return true;
    }

    public boolean canJump2(int[] nums) {

        int len = nums.length;
        if (len == 1) {
            return true;
        }

        int maxJump = nums[0];

        for (int i = 1; i <= maxJump; i++) {

            maxJump = Math.max(maxJump, i + nums[i]);
            if (maxJump >= len - 1) {
                return true;
            }
        }

        return false;
    }

}
