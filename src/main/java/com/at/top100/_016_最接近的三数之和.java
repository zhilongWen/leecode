package com.at.top100;

// https://leetcode.cn/problems/3sum-closest/

import java.util.Arrays;

public class _016_最接近的三数之和 {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int len = nums.length;

        for (int k = 0; k < len; k++) {

            int l = k + 1, r = len - 1;
            while (l < r) {
                int sum = nums[r] + nums[l] + nums[k];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                } else if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    return ans;
                }
            }
        }

        return ans;
    }
}
