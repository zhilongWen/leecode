package com.at.top100;

// https://leetcode.cn/problems/jump-game-ii/

public class _045_跳跃游戏II {

    public int jump(int[] nums) {

        int ans = 0;

        for (int i = 0, max = 0, end = 0; i < nums.length - 1; i++) {

            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                ans++;
            }
        }

        return ans;
    }
}
