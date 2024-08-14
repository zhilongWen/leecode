package com.at.top200;

// https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/

public class _154_寻找旋转排序数组中的最小值II {

    public int findMin(int[] nums) {

        int l = 0, r = nums.length - 1;

        while (l < r) {

            int m = l + ((r - l) >> 1);

            if (nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]) {
                r = m;
            } else {
                r--;
            }
        }

        return nums[l];
    }
}
