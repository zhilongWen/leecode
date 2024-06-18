package com.at.top100;

// https://leetcode.cn/problems/merge-sorted-array/description/

public class _088_合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int curr = m + n - 1;
        m = m - 1;
        n = n - 1;

        while (m >= 0 || n >= 0) {

            int p;
            if (m == -1) {
                p = nums2[n--];
            } else if (n == -1) {
                p = nums1[m--];
            } else if (nums1[m] <= nums2[n]) {
                p = nums2[n--];
            } else {
                p = nums1[m--];
            }

            nums1[curr--] = p;
        }
    }
}
