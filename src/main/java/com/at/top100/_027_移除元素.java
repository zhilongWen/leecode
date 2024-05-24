package com.at.top100;


// https://leetcode.cn/problems/remove-element/description/

public class _027_移除元素 {

    public int removeElement(int[] nums, int val) {

        int l = 0, r = 0, len = nums.length;

        while (r < len) {

            if (nums[r] != val) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }

        return l;
    }
}
