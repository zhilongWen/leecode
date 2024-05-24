package com.at.top100;


// https://leetcode.cn/problems/remove-duplicates-from-sorted-array/

public class _026_删除有序数组中的重复项 {

    public int removeDuplicates(int[] nums) {

        int len = nums.length, l = 0, r = 0;

        while (r < len) {

            if (nums[l] != nums[r]) {
                nums[l + 1] = nums[r];
                l++;
            }
            r++;
        }

        return l + 1;
    }
}
