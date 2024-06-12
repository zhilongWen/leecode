package com.at.top100;

// https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/description/

public class _081_搜索旋转排序数组II {

    public boolean search(int[] nums, int target) {

        int len = nums.length;
        if (len == 0) {
            return false;
        }
        if (len == 1) {
            return nums[0] == target;
        }

        int l = 0, r = len - 1;
        while (l <= r) {

            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;
                r--;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return false;
    }
}
