package com.at.top100;

// https://leetcode.cn/problems/sort-colors/description/

public class _075_颜色分类 {

    int[] arr;

    public void sortColors(int[] nums) {

        arr = nums;
        p(0, nums.length - 1, 1);
    }

    public void p(int l, int r, int target) {

        int i = l;
        while (i <= r) {

            if (arr[i] == target) {
                i++;
            } else if (arr[i] < target) {
                swap(i, l);
                i++;
                l++;
            } else {
                swap(i, r);
                r--;
            }
        }
    }

    public void swap(int i, int j) {

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
