package com.at.top100;

// https://leetcode.cn/problems/median-of-two-sorted-arrays/description/

public class _004_寻找两个正序数组的中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int a = (m + n + 1) / 2, b = (m + n + 2) / 2;
        return (findK(nums1, 0, nums2, 0, a) + findK(nums1, 0, nums2, 0, b)) / 2.0;
    }

    public int findK(int[] nums1, int a, int[] nums2, int b, int k) {

        if (a >= nums1.length) return nums2[b + k - 1];
        if (b >= nums2.length) return nums1[a + k - 1];

        if (k == 1) return Math.min(nums1[a], nums2[b]);

        int mK = k >> 1;

        int mA = a + mK - 1 >= nums1.length ? Integer.MAX_VALUE : nums1[a + mK - 1];
        int mB = b + mK - 1 >= nums2.length ? Integer.MAX_VALUE : nums2[b + mK - 1];

        if (mA < mB) {
            return findK(nums1, a + mK, nums2, b, k - mK);
        } else {
            return findK(nums1, a, nums2, b + mK, k - mK);
        }
    }
}
