package com.at.algorithmzuo;


// 按奇偶排序数组II
// 给定一个非负整数数组 nums。nums 中一半整数是奇数 ，一半整数是偶数
// 对数组进行排序，以便当 nums[i] 为奇数时，i也是奇数
// 当 nums[i] 为偶数时， i 也是 偶数
// 你可以返回 任何满足上述条件的数组作为答案
// 测试链接 : https://leetcode.cn/problems/sort-array-by-parity-ii/


import java.util.Arrays;

public class 双指针_001_922_按奇偶排序数组II {

    public int[] sortArrayByParityII(int[] nums) {

        int n = nums.length;

        int a = 0; // 偶数位指针
        int b = 1; // 奇数位指针

        for (; a < n && b < n; ) {

            if ((nums[n - 1] & 1) == 1) {
                swap(nums, b, n - 1);
                b += 2;
            } else {
                swap(nums, a, n - 1);
                a += 2;
            }

        }

        return nums;

    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
