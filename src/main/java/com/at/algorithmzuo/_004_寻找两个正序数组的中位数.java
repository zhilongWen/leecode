package com.at.algorithmzuo;

public class _004_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int a = (m + n + 1) / 2, b = (m + n + 2) / 2;

        int v1 = f(nums1, 0, nums2, 0, a);
        int v2 = f(nums1, 0, nums2, 0, b);

        return (v2 + v1) / 2.0;

    }


    public int f(int[] num1, int a, int num2[], int b, int k) {

        if (a >= num1.length) return num2[b + k - 1];
        if (b >= num2.length) return num1[a + k - 1];

        if (k == 1) return Math.min(num1[a], num2[b]);

        int midK = k >> 1;

        int minA = midK + a - 1 >= num1.length ? Integer.MAX_VALUE : num1[midK + a - 1];
        int minB = midK + b - 1 >= num2.length ? Integer.MAX_VALUE : num2[midK + b - 1];

        if (minA < minB) {
            return f(num1, a + midK, num2, b, k - midK);
        } else {
            return f(num1, a, num2, b + midK, k - midK);
        }


    }

}
