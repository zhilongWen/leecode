package com.at.top100;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/

public class _080_删除有序数组中的重复项II {

    public int removeDuplicates(int[] nums) {
        return f(nums, 2);
    }

    public int f(int[] nums, int k) {

        int idx = 0;
        for (int num : nums) {
            if (idx < 2 || nums[idx - k] != num) {
                nums[idx++] = num;
            }
        }

        return idx;
    }
}
