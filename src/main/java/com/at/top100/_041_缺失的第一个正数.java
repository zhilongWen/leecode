package com.at.top100;

// https://leetcode.cn/problems/first-missing-positive/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _041_缺失的第一个正数 {

    public int firstMissingPositive(int[] nums) {

        int l = 0, r = nums.length;

        while (l < r) {
            if (nums[l] == l + 1) {
                l++;
            } else if (nums[l] < l + 1 || nums[l] > r || nums[l] == nums[nums[l] - 1]) {
                swap(nums, l, --r);
            } else {
                swap(nums, l, nums[l] - 1);
            }
        }

        return l + 1;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
