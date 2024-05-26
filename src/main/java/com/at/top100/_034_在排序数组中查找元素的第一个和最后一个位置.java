package com.at.top100;


// https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/

public class _034_在排序数组中查找元素的第一个和最后一个位置 {

    public int[] searchRange(int[] nums, int target) {

        int s = search(nums, target);
        if (s == nums.length || nums[s] != target) {
            return new int[]{-1, -1};
        }

        int e = search(nums, target + 1) - 1;

        return new int[]{s, e};
    }

    public int search(int[] nums, int target) {

        int l = 0, r = nums.length - 1;

        while (l <= r) {

            int mid = l + ((r - l) >> 1);
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}
