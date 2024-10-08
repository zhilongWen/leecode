package com.at.top200;

// https://leetcode.cn/problems/find-peak-element/

public class _162_寻找峰值 {

    public int findPeakElement(int[] nums) {

        int l = 0, r = nums.length - 1;

        while (l < r) {

            int mid = l + ((r - l) >> 1);

            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }
}
